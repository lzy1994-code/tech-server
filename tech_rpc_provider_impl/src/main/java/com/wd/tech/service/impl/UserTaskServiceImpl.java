package com.wd.tech.service.impl;

import com.wd.tech.dao.UserTaskMapper;
import com.wd.tech.rpc.pojo.UserIntegral;
import com.wd.tech.rpc.pojo.UserSign;
import com.wd.tech.rpc.pojo.UserTask;
import com.wd.tech.service.UserIntegralService;
import com.wd.tech.service.UserSignService;
import com.wd.tech.service.UserTaskRecordService;
import com.wd.tech.service.UserTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xyj on 2018/9/21.
 */
@Service("userTaskService")
public class UserTaskServiceImpl implements UserTaskService {

    @Resource
    private UserTaskMapper userTaskMapper;

    @Resource
    private UserTaskRecordService userTaskRecordService;

    @Resource
    private UserIntegralService userIntegralService;

    @Resource
    private UserSignService userSignService;

    @Override
    public List<UserTask> findAllTaskList() {
        return userTaskMapper.findAllTaskList();
    }

    @Override
    public List<UserTask> findUserDailyTaskList(int userId) {
        return userTaskMapper.findUserDailyTaskList(userId);
    }

    @Override
    public List<UserTask> findUserOneTimeTaskList(int userId) {
        return userTaskMapper.findUserOneTimeTaskList(userId);
    }

    @Override
    public int doTheTask(int userId, int taskId) {

        //添加做任务记录
        int num = userTaskRecordService.addUserTaskRecord(userId, taskId);
        if(num == 0)
        {
            return 0;
        }

        //根据所做任务给予用户对应的积分奖励
        UserTask userTask = null;
        int type = 0;
        switch (taskId)
        {
            case UserTask.TASK_MRQD:
                userTask = findUserTaskById(UserTask.TASK_MRQD);
                type = UserIntegral.TYPE_QD;

                //涉及到连续签到业务，所以要做下积分的处理
                int userSignStatus = userSignService.findUserSignStatus(userId);
                //如果今天签到
                if(userSignStatus == 1)
                {
                    UserSign userSign = userSignService.findUserSign(userId);
                    int lxqd = userSign.getContinuousSign();
                    int integral = 10;
                    switch (lxqd)
                    {
                        case 1:
                            integral = 10;
                            break;
                        case 2:
                            integral = 20;
                            break;
                        case 3:
                            integral = 30;
                            break;
                        case 4:
                            integral = 40;
                            break;
                        case 5:
                            integral = 50;
                            break;
                            default:
                                integral = 50;
                                break;
                    }
                    userTask.setIntegral(integral);
                }
                break;
            case UserTask.TASK_MRSP:
                userTask = findUserTaskById(UserTask.TASK_MRSP);
                type = UserIntegral.TYPE_PL;
                break;
            case UserTask.TASK_MRFT:
                userTask = findUserTaskById(UserTask.TASK_MRFT);
                type = UserIntegral.TYPE_FT;
                break;
            case UserTask.TASK_MRFX:
                userTask = findUserTaskById(UserTask.TASK_MRFX);
                type = UserIntegral.TYPE_FX;
                break;
            case UserTask.TASK_CKGG:
                userTask = findUserTaskById(UserTask.TASK_CKGG);
                type = UserIntegral.TYPE_CKGG;
                break;
            case UserTask.TASK_WSYHXX:
                userTask = findUserTaskById(UserTask.TASK_WSYHXX);
                type = UserIntegral.TYPE_WSXX;
                break;
            case UserTask.TASK_BDWX:
                userTask = findUserTaskById(UserTask.TASK_BDWX);
                type = UserIntegral.TYPE_BDWX;
                break;
                default:
                    userTask = new UserTask();
                    break;
        }

        if(userTask == null)
        {
            return 0;
        }

        //用户积分变动
        userIntegralService.integralChange(userId,userTask.getIntegral(),type,UserIntegral.DIRECTION_SR,null);

        return 1;
    }

    @Override
    public UserTask findUserTaskById(int taskId) {
        return userTaskMapper.findUserTaskById(taskId);
    }
}

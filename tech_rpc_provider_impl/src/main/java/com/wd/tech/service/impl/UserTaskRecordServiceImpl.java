package com.wd.tech.service.impl;

import com.wd.tech.dao.UserTaskRecordMapper;
import com.wd.tech.rpc.pojo.UserTask;
import com.wd.tech.rpc.pojo.UserTaskRecord;
import com.wd.tech.service.UserTaskRecordService;
import com.wd.tech.service.UserTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by xyj on 2018/9/21.
 */
@Service("userTaskRecordService")
public class UserTaskRecordServiceImpl implements UserTaskRecordService {

    @Resource
    private UserTaskRecordMapper userTaskRecordMapper;

    @Resource
    private UserTaskService userTaskService;

    @Override
    public int addUserTaskRecord(int userId,int taskId) {

        UserTask userTask = userTaskService.findUserTaskById(taskId);

        if(userTask == null)
        {
            return 0;
        }

        //判断用户是否能做任务
        int userTaskStatus = 0;
        //如果是每日任务
        if(UserTask.TYPE_MR == userTask.getType())
        {
            userTaskStatus = userTaskRecordMapper.findUserTaskStatus(userId, taskId,new Date());
        }
        else
        {
            userTaskStatus = userTaskRecordMapper.findUserTaskStatus(userId, taskId,null);
        }

        if(userTaskStatus > 0)
        {
            return 0;
        }

        UserTaskRecord record = new UserTaskRecord();
        record.setTaskId(taskId);
        record.setUserId(userId);
        record.setTaskTime(new Date());

        return userTaskRecordMapper.addUserTaskRecord(record);
    }

}

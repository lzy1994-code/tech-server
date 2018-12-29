package com.wd.tech.service;

import com.wd.tech.rpc.pojo.UserTask;

import java.util.List;

/**
 * Created by xyj on 2018/9/21.
 */
public interface UserTaskService {

    /**
     *  查询所有任务
     * @return
     */
    List<UserTask> findAllTaskList();

    /**
     *  查询用户每日任务信息
     * @param userId
     * @return
     */
    List<UserTask> findUserDailyTaskList(int userId);

    /**
     *  查询用户所有已做过的一次性任务
     * @param userId
     * @return
     */
    List<UserTask> findUserOneTimeTaskList(int userId);

    /**
     *  做任务
     * @param userId
     * @param taskId
     * @return
     */
    int doTheTask(int userId,int taskId);

    /**
     *  根据任务ID查询任务信息
     * @param taskId
     * @return
     */
    UserTask findUserTaskById(int taskId);

}

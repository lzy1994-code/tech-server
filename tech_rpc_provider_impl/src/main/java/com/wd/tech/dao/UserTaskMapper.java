package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.UserTask;

import java.util.List;

/**
 * Created by xyj on 2018/9/21.
 */
public interface UserTaskMapper {

    List<UserTask> findAllTaskList();

    List<UserTask> findUserDailyTaskList(int userId);

    List<UserTask> findUserOneTimeTaskList(int userId);

    UserTask findUserTaskById(int taskId);

}

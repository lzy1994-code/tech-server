package com.wd.tech.service;

/**
 * Created by xyj on 2018/9/21.
 */
public interface UserTaskRecordService {

    /**
     *  添加做任务记录
     * @param userId
     * @param taskId
     * @return
     */
    int addUserTaskRecord(int userId,int taskId);

}

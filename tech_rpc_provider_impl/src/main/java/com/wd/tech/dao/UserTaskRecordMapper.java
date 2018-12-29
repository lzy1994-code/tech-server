package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.UserTaskRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by xyj on 2018/9/21.
 */
public interface UserTaskRecordMapper {

    int addUserTaskRecord(UserTaskRecord userTaskRecord);

    int findUserTaskStatus(@Param("userId") int userId, @Param("taskId") int taskId,@Param("nowTime") Date nowTime);

}

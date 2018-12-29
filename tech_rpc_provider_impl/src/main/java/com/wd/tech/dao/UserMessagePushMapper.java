package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.UserMessagePush;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xyj on 2018/8/13.
 */
public interface UserMessagePushMapper {

    int addUserMessagePush(UserMessagePush userMessagePush);

    UserMessagePush getUserMessagePush(int userId);

    int findUserMessagePush(@Param("userId") int userId, @Param("token") String token);

    int deleteByUserId(int userId);

}

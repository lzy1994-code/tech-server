package com.wd.tech.service;


import com.wd.tech.rpc.pojo.UserMessagePush;

/**
 * Created by xyj on 2018/8/13.
 */
public interface UserMessagePushService {

    int saveUserMessagePush(UserMessagePush userMessagePush);

    UserMessagePush getUserMessagePush(int userId);

    int findUserMessagePush(int userId, String token);

    int deleteUserMessagePush(int userId);

}

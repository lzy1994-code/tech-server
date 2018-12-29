package com.wd.tech.service;

import com.wd.tech.rpc.pojo.UserSign;

/**
 * Created by xyj on 2018/9/28.
 */
public interface UserSignService {

    //签到
    int userSign(int userId);

    //查询当天签到状态
    int findUserSignStatus(int userId);

    //查询用户最新签到数据
    UserSign findUserSign(int userId);
}

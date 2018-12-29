package com.wd.tech.dao;


import com.wd.tech.rpc.pojo.UserBindingLogin;

/**
 * Created by xyj on 2018/8/10.
 */
public interface UserBindingLoginMapper {

    int saveUserBindingLogin(UserBindingLogin userBindingLogin);

    UserBindingLogin findUserBindingByOpenId(String openId);

    UserBindingLogin findUserBindingByUserId(int userId);

}

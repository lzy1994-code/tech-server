package com.wd.tech.service;


import com.wd.tech.rpc.pojo.UserBindingLogin;

/**
 * Created by xyj on 2018/8/10.
 */
public interface UserBindingLoginService {

    /**
     *  保存三方登陆信息
     * @param userBindingLogin
     * @return
     */
    int saveUserBindingLogin(UserBindingLogin userBindingLogin);

    /**
     *  根据openId查询
     * @param openId
     * @return
     */
    UserBindingLogin findUserBindingByOpenId(String openId);

    /**
     *  根据用户ID查询
     * @param userId
     * @return
     */
    UserBindingLogin findUserBindingByUserId(int userId);

}

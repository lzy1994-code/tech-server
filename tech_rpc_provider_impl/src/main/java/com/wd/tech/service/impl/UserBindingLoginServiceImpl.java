package com.wd.tech.service.impl;

import com.wd.tech.dao.UserBindingLoginMapper;
import com.wd.tech.rpc.pojo.UserBindingLogin;
import com.wd.tech.service.UserBindingLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/8/10.
 */
@Service("userBindingLoginService")
public class UserBindingLoginServiceImpl implements UserBindingLoginService {

    @Resource
    private UserBindingLoginMapper userBindingLoginMapper;

    @Override
    public int saveUserBindingLogin(UserBindingLogin userBindingLogin) {
        return userBindingLoginMapper.saveUserBindingLogin(userBindingLogin);
    }

    @Override
    public UserBindingLogin findUserBindingByOpenId(String openId) {
        return userBindingLoginMapper.findUserBindingByOpenId(openId);
    }

    @Override
    public UserBindingLogin findUserBindingByUserId(int userId) {
        return userBindingLoginMapper.findUserBindingByUserId(userId);
    }
}

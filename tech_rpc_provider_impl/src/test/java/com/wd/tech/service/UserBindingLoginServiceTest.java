package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by xyj on 2018/10/12.
 */
@Ignore
public class UserBindingLoginServiceTest extends BaseTest {

    @Resource
    private UserBindingLoginService userBindingLoginService;

    @Test
    public void saveUserBindingLogin() {

    }

    @Test
    public void findUserBindingByOpenId() {

        System.out.println(userBindingLoginService.findUserBindingByOpenId("1016"));

    }

    @Test
    public void findUserBindingByUserId() {
        System.out.println(userBindingLoginService.findUserBindingByUserId(1016));
    }
}
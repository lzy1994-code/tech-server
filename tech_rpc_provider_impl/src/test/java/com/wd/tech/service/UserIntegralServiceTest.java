package com.wd.tech.service;

import com.wd.base.BaseTest;
import com.wd.tech.rpc.pojo.UserIntegral;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

@Ignore
public class UserIntegralServiceTest extends BaseTest {

    @Resource
    private UserIntegralService userIntegralService;

    @Test
    public void findUserIntegral() {
        UserIntegral userIntegral = userIntegralService.findUserIntegral(1001);
        System.out.println(userIntegral);
    }
}
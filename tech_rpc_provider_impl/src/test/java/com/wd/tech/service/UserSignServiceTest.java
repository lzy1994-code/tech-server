package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/9/30.
 */
@Ignore
public class UserSignServiceTest extends BaseTest {

    @Resource
    private UserSignService userSignService;

    @Test
    public void userSign() {

        System.out.println(userSignService.userSign(1027));

    }

    @Test
    public void findUserSignStatus() {

        System.out.println(userSignService.findUserSignStatus(1001));

    }

    @Test
    public void findUserSign() {

        System.out.println(userSignService.findUserSign(1001));

    }
}
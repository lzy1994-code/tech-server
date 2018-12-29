package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@Ignore
public class FocusUserServiceTest extends BaseTest {

    @Resource
    private FocusUserService focusUserService;

    @Test
    public void findFollowUserList() {
    }

    @Test
    public void addFollow() {
        boolean b = focusUserService.addFollow(1010, 1012);
        System.out.println(b);
    }

    @Test
    public void whetherFollowUser() {
        int i = focusUserService.whetherFollowUser(1010, 1012);
        System.out.println(i);

    }

    @Test
    public void cancelFollow() {
        boolean b = focusUserService.cancelFollow(1010, 1012);
        System.out.println(b);

    }

    @Test
    public void whetherMutualFollow() {
    }
}
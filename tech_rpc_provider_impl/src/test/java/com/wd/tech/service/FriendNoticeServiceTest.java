package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

@Ignore
public class FriendNoticeServiceTest extends BaseTest {

    @Resource
    private FriendNoticeService friendNoticeService;

    @Test
    public void increaseFriendNotice() {
        int i = friendNoticeService.increaseFriendNotice(1000, 1001, "我是。。。");
        System.out.println(i);
    }

    @Test
    public void findFriendNoticePageList() {
    }

    @Test
    public void pass() {
    }

    @Test
    public void reject() {
    }

    @Test
    public void findLastFriendNotice() {
    }

    @Test
    public void findFriendNoticeById() {
    }
}
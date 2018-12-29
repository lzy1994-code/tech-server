package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by xyj on 2018/9/22.
 */
@Ignore
public class UserTaskServiceTest extends BaseTest {

    @Resource
    private UserTaskService userTaskService;

    @Test
    public void findAllTaskList() {

        System.out.println(userTaskService.findAllTaskList());

    }

    @Test
    public void findUserDailyTaskList() {

        System.out.println(userTaskService.findUserDailyTaskList(5));

    }

    @Test
    public void findUserOneTimeTaskList() {

        System.out.println(userTaskService.findUserOneTimeTaskList(5));

    }
}
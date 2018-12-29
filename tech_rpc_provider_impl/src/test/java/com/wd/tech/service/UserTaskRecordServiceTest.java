package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by xyj on 2018/9/25.
 */
@Ignore
public class UserTaskRecordServiceTest extends BaseTest {

    @Resource
    private UserTaskRecordService userTaskRecordService;

    @Test
    public void addUserTaskRecord() {

        System.out.println(userTaskRecordService.addUserTaskRecord(1007,1006));

    }
}
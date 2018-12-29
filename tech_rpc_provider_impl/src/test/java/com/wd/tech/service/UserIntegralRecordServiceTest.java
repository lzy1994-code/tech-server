package com.wd.tech.service;

import com.wd.base.BaseTest;
import com.wd.tech.rpc.pojo.UserIntegralRecord;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

@Ignore
public class UserIntegralRecordServiceTest extends BaseTest {

    @Resource
    private UserIntegralRecordService userIntegralRecordService;

    @Test
    public void findUserIntegralRecord() {
        List<UserIntegralRecord> userIntegralRecord = userIntegralRecordService.findUserIntegralRecord(1000, 1, 5);
        System.out.println(userIntegralRecord);
    }

    @Test
    public void addUserDetailIntegral() {
        UserIntegralRecord userIntegralRecord = new UserIntegralRecord();
        userIntegralRecord.setUserId(1001);
        userIntegralRecord.setDirection(2);
        userIntegralRecord.setType(6);
        userIntegralRecord.setDetail(-5);
        userIntegralRecord.setRemark("扣除积分");
        int b = userIntegralRecordService.addUserDetailIntegral(userIntegralRecord);
        System.out.println(b);
    }
}
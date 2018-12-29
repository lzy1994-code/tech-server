package com.wd.tech.service;

import com.wd.tech.rpc.pojo.UserIntegralRecord;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户积分明细
 * @author: Lzy
 * @create: 2018-09-03 10:39
 **/
public interface UserIntegralRecordService {
    /**
     * 查询用户积分明细
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<UserIntegralRecord> findUserIntegralRecord(int userId, int page,int count);

    /**
     * 添加用户积分明细
     * @param userIntegralRecord
     * @return
     */
    int addUserDetailIntegral(UserIntegralRecord userIntegralRecord);

}

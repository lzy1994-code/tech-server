package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.UserIntegral;
import org.apache.ibatis.annotations.Param;

/**
 * @program: tech-rpc
 * @description: 用户积分
 * @author: Lzy
 * @create: 2018-09-01 10:51
 **/
public interface UserIntegralMapper {
    /**
     * 查询用户积分
     * @param userId
     * @return
     */
    UserIntegral findUserIntegral(int userId);

    /**
     * 用户积分数修改
     * @param amount
     */
    boolean updateUserIntegral(@Param("amount") int amount, @Param("userId") int userId);

    /**
     *  添加用户积分
     * @param userIntegral
     * @return
     */
    int addUserIntegral(UserIntegral userIntegral);
}

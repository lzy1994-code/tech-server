package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.UserIntegralRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户积分明细
 * @author: Lzy
 * @create: 2018-09-03 09:06
 **/
public interface UserIntegralRecordMapper {

    /**
     * 查询用户积分明细
     * @param userId
     * @return
     */
    List<UserIntegralRecord> findUserIntegralRecord(@Param("userId") int userId, @Param("index") int index, @Param("count") int count);

    /**
     * 添加用户积分明细
     * @param userIntegralRecord
     * @return
     */
    int addUserDetailIntegral(UserIntegralRecord userIntegralRecord);

}

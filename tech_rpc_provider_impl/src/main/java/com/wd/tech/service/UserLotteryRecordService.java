package com.wd.tech.service;

import com.wd.tech.rpc.pojo.UserLotteryRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/9/28.
 */
public interface UserLotteryRecordService {

    /**
     *  添加抽奖记录
     * @param userId
     * @param prizeName
     * @param prizeId
     * @param prizeValue
     * @return
     */
    int addUserLotteryRecord(int userId,String prizeName,int prizeId,int prizeValue);

    /**
     *  查询用户抽奖记录
     * @param userId
     * @param index
     * @param count
     * @return
     */
    List<UserLotteryRecord> findPageList(@Param("userId") int userId, @Param("index") int index, @Param("count") int count);

    /**
     *  领取奖品
     * @param recordId
     * @param userId
     * @return
     */
    int receivePrize(int recordId,int userId);

}

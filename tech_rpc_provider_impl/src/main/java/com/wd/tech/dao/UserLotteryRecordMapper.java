package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.UserLotteryRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/9/28.
 */
public interface UserLotteryRecordMapper {

    int addUserLotteryRecord(UserLotteryRecord userLotteryRecord);

    List<UserLotteryRecord> findPageList(@Param("userId") int userId,@Param("index") int index, @Param("count") int count);

    int updateRecordStatus(@Param("recordId") int recordId,@Param("userId") int userId);

    UserLotteryRecord getUserLotteryRecord(int recordId);

}

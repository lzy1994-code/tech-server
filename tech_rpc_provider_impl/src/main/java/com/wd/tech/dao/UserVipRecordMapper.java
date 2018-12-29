package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.UserVipRecord;

/**
 * Created by xyj on 2018/9/25.
 */
public interface UserVipRecordMapper {

    int addUserVipRecord(UserVipRecord userVipRecord);

    UserVipRecord getUserVipRecordByOrderId(String orderId);

    int modifyPayStatus(String orderId);

}

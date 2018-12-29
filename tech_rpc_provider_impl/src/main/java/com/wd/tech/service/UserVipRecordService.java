package com.wd.tech.service;

import com.wd.tech.rpc.pojo.UserVipRecord;

/**
 * Created by xyj on 2018/9/25.
 */
public interface UserVipRecordService {

    int addUserVipRecord(int userId,String orderId,int commodityId,double price);

    UserVipRecord getUserVipRecordByOrderId(String orderId);

    int modifyPayStatus(String orderId);

}

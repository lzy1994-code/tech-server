package com.wd.tech.service.impl;

import com.wd.tech.dao.UserVipRecordMapper;
import com.wd.tech.rpc.pojo.UserVipRecord;
import com.wd.tech.service.CommodityService;
import com.wd.tech.service.UserVipRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by xyj on 2018/9/25.
 */
@Service("userVipRecordService")
public class UserVipRecordServiceImpl implements UserVipRecordService {

    @Resource
    private UserVipRecordMapper userVipRecordMapper;

    @Resource
    private CommodityService commodityService;

    @Override
    public int addUserVipRecord(int userId,String orderId,int commodityId,double price) {
        UserVipRecord userVipRecord = new UserVipRecord();
        userVipRecord.setUserId(userId);
        userVipRecord.setAfterPurchase(null);
        userVipRecord.setBeforePurchase(null);
        userVipRecord.setBuyTime(new Date());
        userVipRecord.setOrderId(orderId);
        userVipRecord.setMoney(price);
        userVipRecord.setStatus(UserVipRecord.PAY_STATUS_NO);
        return userVipRecordMapper.addUserVipRecord(userVipRecord);
    }

    @Override
    public UserVipRecord getUserVipRecordByOrderId(String orderId) {
        return userVipRecordMapper.getUserVipRecordByOrderId(orderId);
    }

    @Override
    public int modifyPayStatus(String orderId) {
        return userVipRecordMapper.modifyPayStatus(orderId);
    }
}

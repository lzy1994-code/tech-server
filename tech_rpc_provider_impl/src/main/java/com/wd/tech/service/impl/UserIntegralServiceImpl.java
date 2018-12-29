package com.wd.tech.service.impl;

import com.wd.tech.dao.UserIntegralMapper;
import com.wd.tech.rpc.pojo.UserIntegral;
import com.wd.tech.rpc.pojo.UserIntegralRecord;
import com.wd.tech.service.UserIntegralRecordService;
import com.wd.tech.service.UserIntegralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 用户积分实现类
 * @author: Lzy
 * @create: 2018-09-03 10:41
 **/
@Service("userIntegralService")
public class UserIntegralServiceImpl implements UserIntegralService {

    private Logger logger = LoggerFactory.getLogger("userIntegralService");

    @Resource
    private UserIntegralMapper userIntegralMapper;
    @Resource
    private UserIntegralRecordService userIntegralRecordService;

    @Override
    public UserIntegral findUserIntegral(int userId) {

        UserIntegral userIntegral = userIntegralMapper.findUserIntegral(userId);

        if(userIntegral == null)
        {
            userIntegral = new UserIntegral();
            userIntegral.setUserId(userId);
            userIntegral.setAmount(0);
            userIntegral.setCreateTime(new Date());
            userIntegralMapper.addUserIntegral(userIntegral);
        }
        return userIntegral;
    }


    @Override
    public int findIntegralNum(int userId) {
        UserIntegral userIntegral = userIntegralMapper.findUserIntegral(userId);
        if(userIntegral == null)
        {
            return 0;
        }
        return userIntegral.getAmount();
    }

    @Override
    public int integralChange(int userId, int amount, int type, int direction, String remark) {

        try {
            //查询用户积分
            UserIntegral userIntegral = findUserIntegral(userId);

            //修改用户积分
            if(direction == UserIntegral.DIRECTION_ZC)
            {
                amount = -amount;
            }
            userIntegralMapper.updateUserIntegral(amount,userId);

            //增加积分记录
            UserIntegralRecord userIntegralRecord = new UserIntegralRecord();
            userIntegralRecord.setUserId(userId);
            userIntegralRecord.setBalance(userIntegral.getAmount());
            userIntegralRecord.setDetail(amount);
            userIntegralRecord.setDirection(direction);
            userIntegralRecord.setType(type);
            userIntegralRecord.setRemark(remark);
            userIntegralRecordService.addUserDetailIntegral(userIntegralRecord);

            return 1;
        } catch (Exception e) {
            logger.error("integralChange={}",e);
            return 0;
        }
    }


}

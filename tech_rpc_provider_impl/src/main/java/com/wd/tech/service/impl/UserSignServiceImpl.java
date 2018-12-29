package com.wd.tech.service.impl;

import com.wd.tech.dao.UserSignMapper;
import com.wd.tech.rpc.pojo.UserSign;
import com.wd.tech.service.UserSignService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by xyj on 2018/9/28.
 */
@Service("userSignService")
public class UserSignServiceImpl implements UserSignService {

    private Logger logger = LoggerFactory.getLogger("userSignService");

    @Resource
    private UserSignMapper userSignMapper;

    @Override
    public int userSign(int userId) {

        try {
            //判断今天是否签到
            int userSignStatus = findUserSignStatus(userId);
            if(userSignStatus > 0)
            {
                    return 2;
            }

            //查询用户昨天的签到数据
            DateTime yesterDay = new DateTime();
            yesterDay = yesterDay.minusDays(1);
            UserSign userYesterdaySign = userSignMapper.findUserYesterdaySign(userId,yesterDay.toString("yyyy-MM-dd"));
            if(userYesterdaySign == null)
            {
                return createUserSign(userId, 1);
            }

            return createUserSign(userId, userYesterdaySign.getContinuousSign()+1);
        } catch (Exception e) {
            logger.error("userSign",e);
            return 0;
        }
    }

    private int createUserSign(int userId, int signDayNum) {
        UserSign userSign = new UserSign();
        userSign.setUserId(userId);
        userSign.setContinuousSign(signDayNum);
        userSign.setSignTime(new Date());
        return userSignMapper.addUserSign(userSign);
    }

    @Override
    public int findUserSignStatus(int userId) {

        UserSign userSignStatus = userSignMapper.getUserSignStatus(userId);
        if(userSignStatus != null)
        {
            return 1;
        }
        return 0;
    }

    @Override
    public UserSign findUserSign(int userId) {
        return userSignMapper.findUserSign(userId);
    }
}

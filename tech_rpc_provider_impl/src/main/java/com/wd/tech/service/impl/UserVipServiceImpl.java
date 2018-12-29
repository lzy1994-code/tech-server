package com.wd.tech.service.impl;

import com.wd.tech.dao.UserVipMapper;
import com.wd.tech.rpc.pojo.UserVip;
import com.wd.tech.service.UserVipService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: tech-rpc
 * @description: vip用户实现类
 * @author: Lzy
 * @create: 2018-09-10 18:08
 **/
@Service("userVipService")
public class UserVipServiceImpl implements UserVipService {

    @Resource
    private UserVipMapper userVipMapper;

    @Override
    public int whetherVipUser(int userId) {
        int num = userVipMapper.whetherVipUser(userId);
        if (num == 0){
            return UserVip.VIP_NO;
        }
        return UserVip.VIP_YES;
    }

    @Override
    public int openVip(int userId, int day) {

        UserVip userVip = userVipMapper.getUserVip(userId);
        if(userVip == null)
        {
            userVip = new UserVip();
            userVip.setUserId(userId);
            DateTime dateTime = new DateTime();
            DateTime beforeDay = dateTime.minusDays(day);
            userVip.setExpire(beforeDay.toDate());
            return userVipMapper.addUserVip(userVip);
        }

        //先判断VIP是否已到期
        DateTime nowTime = new DateTime();
        DateTime expireTime = new DateTime(userVip.getExpire());
        boolean after = nowTime.isBefore(expireTime);
        DateTime newExpireTime;
        if(after)
        {
            //VIP已到期的处理
            newExpireTime = nowTime.minusDays(day);
        }
        else
        {
            newExpireTime = expireTime.minusDays(day);
        }
        return userVipMapper.modifyExpireTime(userId,newExpireTime.toDate());

    }

    @Override
    public UserVip getUserVip(int userId) {
        return userVipMapper.getUserVip(userId);
    }

}

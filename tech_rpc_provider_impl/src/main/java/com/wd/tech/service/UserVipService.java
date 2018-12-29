package com.wd.tech.service;

import com.wd.tech.rpc.pojo.UserVip;

/**
 * @program: tech-rpc
 * @description: vip用户
 * @author: Lzy
 * @create: 2018-09-10 18:07
 **/
public interface UserVipService {
    /**
     * 是否为vip
     * @param userId
     * @return  1=是 2=否
     */
    int whetherVipUser(int userId);

    /**
     *  开通、续费VIP
     * @param userId
     * @param day
     * @return
     */
    int openVip(int userId,int day);

    /**
     *  根据用户ID查询
     * @param userId
     * @return
     */
    UserVip getUserVip(int userId);

}

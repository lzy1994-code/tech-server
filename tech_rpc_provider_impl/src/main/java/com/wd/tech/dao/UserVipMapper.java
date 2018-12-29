package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.UserVip;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @program: tech-rpc
 * @description: vip用户
 * @author: Lzy
 * @create: 2018-09-07 11:22
 **/
public interface UserVipMapper {

    int addUserVip(UserVip userVip);

    /**
     * 是否为vip
     * @param userId
     * @return
     */
    int whetherVipUser(int userId);

    /**
     *  根据用户ID查询
     * @param userId
     * @return
     */
    UserVip getUserVip(int userId);

    /**
     *  修改到期时间
     * @param userId
     * @param expireTime
     * @return
     */
    int modifyExpireTime(@Param("userId") int userId,@Param("expireTime") Date expireTime);
}

package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.UserSign;
import org.apache.ibatis.annotations.Param;

/**
 * @program: tech-rpc
 * @description: 用户签到
 * @author: Lzy
 * @create: 2018-09-05 13:50
 **/
public interface UserSignMapper {

    //签到
    int addUserSign(UserSign userSign);

    //查询当天签到状态
    UserSign getUserSignStatus(int userId);

    //查询用户最新签到数据
    UserSign findUserSign(int userId);

    //查询昨天签到数据
    UserSign findUserYesterdaySign(@Param("userId") int userId,@Param("yesterday") String yesterday);

}

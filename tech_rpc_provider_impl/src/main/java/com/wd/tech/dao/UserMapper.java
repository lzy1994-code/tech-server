package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/8/27.
 */
public interface UserMapper {

    int addUser(User user);

    User getUserInfoById(int userId);

    int modifyNickName(@Param("userId") int userId,@Param("nickName") String nickName);

    int modifySignature(@Param("userId")int userId,@Param("signature")String signature);

    int modifyHeadPic(@Param("userId")int userId,@Param("headPic")String headPic);

    int modifyEmail(@Param("userId")int userId,@Param("email")String email);

    int modifyLoginTime(@Param("userId")int userId);

    int checkNickName(@Param("nickName")String nickName);

    int checkPhone(@Param("phone")String phone);

    User login(@Param("phone") String phone,@Param("pwd") String pwd);

    int updateUserPwd(@Param("userId")int userId,@Param("newPwd")String newPwd,@Param("oldPwd")String oldPwd);

    int perfectUserInfo(User user);

    List<User> findUserByUserNames(List<String> list);

    int findMaxNum();

    int modifyFaceId(@Param("userId")int userId,@Param("faceId")String faceId);

    User findUserByFaceId(String faceId);

    User findUserByPhone(String phone);

}

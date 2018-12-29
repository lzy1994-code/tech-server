package com.wd.tech.service;


import com.wd.tech.rpc.pojo.User;
import com.wd.tech.rpc.pojo.UserCache;
import com.wd.tech.rpc.pojo.UserSign;
import com.wd.tech.rpc.vo.UserLoginVo;

import java.util.Date;
import java.util.List;

/**
 * Created by xyj on 2018/8/27.
 */
public interface UserService {

    /**
     *  根据用户ID查询用户信息
     * @param userId
     * @return
     */
    User getUserInfoById(int userId);

    /**
     *  查询缓存的用户信息
     * @param userId
     * @return
     */
    UserCache getCacheUser(int userId);

    /**
     *  注册用户
     * @param user
     * @return
     */
    int register(User user);

    /**
     *  登录
     * @param phone
     * @param pwd
     * @return
     */
    UserLoginVo login(String phone, String pwd);

    /**
     * 登陆
     * @param userId
     * @return
     */
    User login(int userId);

    /**
     *  修改用户昵称
     * @param userId
     * @param nickName
     * @return
     */
    int modifyNickName(int userId,String nickName);

    /**
     *  修改用户签名
     * @param userId
     * @param signature
     * @return
     */
    int modifySignature(int userId,String signature);

    /**
     *  修改头像地址
     * @param userId
     * @param headPic
     * @return
     */
    int modifyHeadPic(int userId,String headPic);

    /**
     *  修改邮箱
     * @param userId
     * @param email
     * @return
     */
    int modifyEmail(int userId,String email);

    /**
     *  修改用户密码
     * @param userId
     * @param newPwd
     * @param oldPwd
     * @return
     */
    int modifyUserPwd(int userId,String newPwd,String oldPwd);

    /**
     *  判断手机号是否可用
     * @param phone
     * @return
     */
    int checkPhone(String phone);

    /**
     *  判断用户昵称是否可用
     * @param nickName
     * @return
     */
    int checkNickName(String nickName);

    /**
     *  刷新用户缓存数据
     * @param userId
     * @return
     */
    UserCache refreshCacheUser(int userId);

    /**
     *  完善个人信息
     * @param nickName
     * @param sex
     * @param signature
     * @param birthday
     * @param email
     * @return
     */
    int perfectUserInfo(int userId,String nickName, int sex, String signature, Date birthday,String email);

    /**
     *  根据环信用户名批量查询用户信息
     * @param list
     * @return
     */
    List<User> findUserByUserNames(List<String> list);

    //签到
    int userSign(int userId);

    //查询当天签到状态
    int findUserSignStatus(int userId);

    //查询用户最新签到数据
    UserSign findUserSign(int userId);

    /**
     * 查询用户总数
     * @return
     */
    int findMaxNum();

    /**
     *  关联人脸ID
     * @param userId
     * @return
     */
    String associateFaceId(int userId);

    /**
     * 根据人脸ID查询
     * @param faceId
     * @return
     */
    User findUserByFaceId(String faceId);

    /**
     * 修改登录时间
     * @param userId
     * @return
     */
    int modifyLoginTime(int userId);

    /**
     *  根据手机号查询用户信息
     * @param phone
     * @return
     */
    User findUserByPhone(String phone);

}

package com.wd.tech.rpc.api;

import com.wd.tech.rpc.pojo.UserInfoCollection;
import com.wd.tech.rpc.pojo.UserIntegral;
import com.wd.tech.rpc.pojo.UserIntegralRecord;
import com.wd.tech.rpc.vo.*;

import java.util.Date;
import java.util.List;

/**
 * Created by xyj on 2018/9/6.
 */
public interface UserRpcService {

    /**
     *  注册用户
     * @param phone
     * @param pwd
     * @param nickName
     * @return
     */
    int register(String phone, String pwd, String nickName);

    /**
     *  用户登录
     * @param phone
     * @param pwd
     * @return
     */
    UserLoginVo login(String phone, String pwd);

    /**
     *  完善用户信息
     * @param nickName
     * @param sex
     * @param signature
     * @param birthday
     * @param email
     * @return
     */
    int perfectUserInfo(int userId, String nickName, int sex, String signature, Date birthday, String email);

    /**
     *  根据用户ID查询用户详细信息
     * @param userId
     * @return
     */
    UserInfoShowVo getUserInfoByUserId(int userId);

    /**
     *  修改用户昵称
     * @param userId
     * @param nickName
     * @return
     */
    int modifyNickName(int userId, String nickName);

    /**
     *  修改用户签名
     * @param userId
     * @param signature
     * @return
     */
    int modifySignature(int userId, String signature);

    /**
     *  修改头像地址
     * @param userId
     * @param headPic
     * @return
     */
    int modifyHeadPic(int userId, String headPic);

    /**
     *  修改邮箱
     * @param userId
     * @param email
     * @return
     */
    int modifyEmail(int userId, String email);

    /**
     *  修改用户密码
     * @param userId
     * @param newPwd
     * @param oldPwd
     * @return
     */
    int modifyUserPwd(int userId, String newPwd, String oldPwd);

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
     * 查询用户积分
     * @param userId
     * @return
     */
    UserIntegral findUserIntegral(int userId);

    /**
     * 查询用户积分明细
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<UserIntegralRecordVo> findUserIntegralRecord(int userId, int page, int count);

    /**
     * 添加用户积分明细
     * @param userIntegralRecord
     * @return
     */
    boolean addUserDetailIntegral(UserIntegralRecord userIntegralRecord);
    /**
     * 用户收藏列表
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<UserInfoCollection> findAllInfoCollection(int userId, int page, int count);

    /**
     * 添加收藏
     * @param userId
     * @param infoId
     * @return
     */
    int addCollection(int userId,int infoId);
    /**
     * 取消收藏
     * @param userId
     * @param infoIds
     * @return
     */
    int cancelCollection(int userId, List<Integer> infoIds);

    /**
     * 用户关注列表
     * @param userId
     * @return
     */
    List<FocusUserVo> findFollowUserList(int userId,int page,int count);

    /**
     * 关注用户
     * @param userId
     * @param focusId
     * @return
     */
    int addFollow( int userId,  int focusId);

    /**
     * 取消关注
     * @param userId
     * @param focusId
     * @return
     */
    int cancelFollow( int userId,int focusId);


    /**
     *  检查登陆状态
     * @param userId
     * @param sessionId
     * @return
     */
    boolean checkUserLoginStatus(int userId, String sessionId);

    /**
     *  根据环信userNames批量查询会话列表需要的信息
     * @param userNames
     * @return
     */
    List<ConversationListVo> findConversationList(String userNames);

    /**
     *  微信登陆
     * @param code
     * @return
     */
    public UserLoginVo wxBindingLogin(String code);

    /**
     *  已注册账号绑定微信账号
     * @param userId
     * @param code
     * @return
     */
    public int bindWeChat(int userId,String code);

    /**
     *  是否绑定微信
     * @param userId
     * @return
     */
    public int whetherToBindWeChat(int userId);

    /**
     *  查询用户任务列表
     * @param userId
     * @return
     */
    public List<UserTaskListVo> findUserTaskList(int userId);

    /**
     *  做任务
     * @param taskId
     * @param userId
     * @return
     */
    public int doTheTask(int taskId,int userId);

    /**
     *  签到
     * @param userId
     * @return
     */
    int userSign(int userId);

    /**
     *  查询当天签到状态
     * @param userId
     * @return
     */
    int findUserSignStatus(int userId);

    /**
     *  查询用户连续签到天数
     * @param userId
     * @return
     */
    int findContinuousSignDays(int userId);

    /**
     * 查询用户总数
     * @return
     */
    int findMaxNum();

    /**
     * 绑定人脸ID
     * @param userId
     * @return
     */
    String bindingFaceId(int userId);

    /**
     * 刷脸登录
     * @param faceId
     * @return
     */
    UserLoginVo faceLogin(String faceId);

    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    UserInfoShowVo findUserByPhone(String phone);

}

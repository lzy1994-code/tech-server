package com.wd.tech.rpc.impl;

import com.bw.pay.client.api.WeChatRpcService;
import com.bw.pay.client.pojo.ProductConstants;
import com.bw.pay.client.pojo.WxLoginVo;
import com.wd.tech.cache.RedisPool;
import com.wd.tech.cache.RedisUtil;
import com.wd.tech.rpc.api.UserRpcService;
import com.wd.tech.rpc.pojo.*;
import com.wd.tech.rpc.vo.*;
import com.wd.tech.service.*;
import com.wd.tech.service.async.RefreshUserThread;
import com.wd.tech.util.*;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by xyj on 2018/9/6.
 */
@Service("userRpcService")
public class UserRpcServiceImpl implements UserRpcService {

    private Logger logger = LoggerFactory.getLogger("userRpcService");

    @Resource
    private UserService userService;
    @Resource
    private UserIntegralService userIntegralService;
    @Resource
    private UserIntegralRecordService userIntegralRecordService;
    @Resource
    private UserInfoCollectionService userInfoCollectionService;
    @Resource
    private UserVipService userVipService;
    @Resource
    private WeChatRpcService weChatRpcService;
    @Resource
    private UserBindingLoginService userBindingLoginService;
    @Resource
    private UserTaskService userTaskService;
    @Resource
    private FocusUserService focusUserService;
    @Resource
    private UserSignService userSignService;


    @Override
    public int register(String phone, String pwd,String nickName) {
        try {
            User user = new User();
            user.setPhone(phone);
            user.setPwd(pwd);
            user.setNickName(nickName);
            return userService.register(user);
        } catch (Exception e) {
            logger.error("register",e);
            return 0;
        }
    }

    @Override
    public UserLoginVo login(String phone, String pwd) {
        try {
            UserLoginVo login = userService.login(phone, pwd);
            if(login == null)
            {
                return null;
            }

            //处理VIP状态
            login.setWhetherVip(userVipService.whetherVipUser(login.getUserId()));

            //缓存登录信息
            cacheLoginInfo(login);

            return login;
        } catch (Exception e) {
            logger.error("login",e);
            return null;
        }
    }

    private void cacheLoginInfo(UserLoginVo user)
    {
        synchronized (user)
        {
            String uid = String.valueOf(user.getUserId());
            String sessionId = System.currentTimeMillis()+uid;
            user.setSessionId(sessionId);

            RedisPool redisPool = RedisUtil.getRedisPool(RedisConstant.POOL_NAME);
            String key = String.format(RedisConstant.USER_SESSION_KEY,uid);
            redisPool.setAndExpire(key,sessionId,604800);
        }
    }

    @Override
    public int perfectUserInfo(int userId,String nickName, int sex, String signature, Date birthday, String email) {
        try {
            return userService.perfectUserInfo(userId,nickName, sex, signature, birthday, email);
        } catch (Exception e) {
            logger.error("perfectUserInfo",e);
            return 0;
        }
    }

    @Override
    public UserInfoShowVo getUserInfoByUserId(int userId) {
        try {
            UserCache cacheUser = userService.getCacheUser(userId);
            UserInfoShowVo result = (UserInfoShowVo)CopyBean.getBean(new UserInfoShowVo(),cacheUser);
            return result;
        } catch (Exception e) {
            logger.error("getUserInfoByUserId",e);
            return null;
        }
    }

    @Override
    public int modifyNickName(int userId, String nickName) {
        try {
            return userService.modifyNickName(userId, nickName);
        } catch (Exception e) {
            logger.error("modifyNickName",e);
            return 0;
        }
    }

    @Override
    public int modifySignature(int userId, String signature) {
        try {
            return userService.modifySignature(userId, signature);
        } catch (Exception e) {
            logger.error("modifySignature",e);
            return 0;
        }
    }

    @Override
    public int modifyHeadPic(int userId, String headPic) {
        try {
            return userService.modifyHeadPic(userId, headPic);
        } catch (Exception e) {
            logger.error("modifyHeadPic",e);
            return 0;
        }
    }

    @Override
    public int modifyEmail(int userId, String email) {
        try {
            return userService.modifyEmail(userId, email);
        } catch (Exception e) {
            logger.error("modifyEmail",e);
            return 0;
        }
    }

    @Override
    public int modifyUserPwd(int userId, String newPwd, String oldPwd) {
        try {
            return userService.modifyUserPwd(userId, newPwd, oldPwd);
        } catch (Exception e) {
            logger.error("modifyUserPwd",e);
            return 0;
        }
    }

    @Override
    public int checkPhone(String phone) {
        try {
            return userService.checkPhone(phone);
        } catch (Exception e) {
            logger.error("checkPhone",e);
            return 0;
        }
    }

    @Override
    public int checkNickName(String nickName) {
        try {
            return userService.checkNickName(nickName);
        } catch (Exception e) {
            logger.error("checkNickName",e);
            return 0;
        }
    }

    @Override
    public UserIntegral findUserIntegral(int userId) {
        UserIntegral userIntegral = userIntegralService.findUserIntegral(userId);
        if (userIntegral==null){
            return null;
        }
        return userIntegral;
    }

    @Override
    public List<UserIntegralRecordVo> findUserIntegralRecord(int userId, int page, int count) {
        try {
            List<UserIntegralRecord> userIntegralRecord = userIntegralRecordService.findUserIntegralRecord(userId, page, count);
            if (userIntegralRecord.isEmpty()){
                return new ArrayList<>();
            }

            List<UserIntegralRecordVo> result = new ArrayList<>();
            UserIntegralRecordVo vo;
            for(UserIntegralRecord temp:userIntegralRecord)
            {
                vo = (UserIntegralRecordVo)CopyBean.getBean(new UserIntegralRecordVo(),temp);
                vo.setAmount(temp.getDetail());
                result.add(vo);
            }
            return result;
        } catch (Exception e) {
            logger.error("findUserIntegralRecord",e);
            return new ArrayList<>();
        }
    }

    @Override
    public boolean addUserDetailIntegral(UserIntegralRecord userIntegralRecord) {
        return  userIntegralRecordService.addUserDetailIntegral(userIntegralRecord) == 1 ? true:false;
    }

    @Override
    public List<UserInfoCollection> findAllInfoCollection(int userId, int page, int count) {
        List<UserInfoCollection> allInfoCollection = userInfoCollectionService.findAllInfoCollection(userId, page, count);
        if (allInfoCollection.isEmpty()){
            return new ArrayList<>();
        }
        return allInfoCollection;
    }

    @Override
    public int addCollection(int userId, int infoId) {
        int i = userInfoCollectionService.whetherCollection(userId, infoId);
        if(i==1){
            return 2;
        }
        boolean b = userInfoCollectionService.addCollection(userId, infoId);
        if (b){
            return 1;
        }
        return 0;
    }

    @Override
    public int cancelCollection(int userId, List<Integer> infoIds) {
        boolean b = userInfoCollectionService.cancelCollection(userId, infoIds);
        if (b){
            return 1;
        }
        return 0;
    }

    @Override
    public List<FocusUserVo> findFollowUserList(int userId,int page,int count) {
        List<FocusUserVo> followUserList = focusUserService.findFollowUserList(userId,page,count);
        if (followUserList.isEmpty()){
            return new ArrayList<>();
        }
        return followUserList;
    }

    @Override
    public int addFollow(int userId, int focusId) {
        int i = focusUserService.whetherFollowUser(userId, focusId);
        if (i==1){
            return 2;
        }
        boolean b = focusUserService.addFollow(userId, focusId);
        if (b){
            return 1;
        }
        return 0;
    }

    @Override
    public int cancelFollow(int userId, int focusId) {
        boolean b = focusUserService.cancelFollow(userId, focusId);
        if (b){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean checkUserLoginStatus(int userId, String sessionId) {
        RedisPool redisPool = RedisUtil.getRedisPool(RedisConstant.POOL_NAME);
        String key = String.format(RedisConstant.USER_SESSION_KEY,userId);
        String temp = redisPool.get(key);
        if(temp == null)
        {
            return false;
        }

        if(!sessionId.equals(temp))
        {
            return false;
        }
        return true;
    }

    @Override
    public List<ConversationListVo> findConversationList(String userNames) {
        if(null == userNames || "".equals(userNames))
        {
            return new ArrayList<>();
        }
        String [] temps = userNames.split(",");
        List<String> list = Arrays.asList(temps);
        List<User> users = userService.findUserByUserNames(list);
        List<ConversationListVo> result = new ArrayList<>();
        ConversationListVo vo;
        for(User user:users)
        {
            vo = new ConversationListVo();
            vo.setUserId(user.getId());
            vo.setHeadPic(user.getHeadPic());
            vo.setNickName(user.getNickName());
            vo.setPwd(user.getPwd());
            vo.setUserName(user.getUserName());
            result.add(vo);
        }
        return result;
    }

    @Override
    public UserLoginVo wxBindingLogin(String code) {
        //根据code获取微信用户的openid
        WxLoginVo wxLogin = weChatRpcService.getOpenId(code, ProductConstants.PRODUCT_TECH);
        if(wxLogin == null)
        {
            logger.info("获取openId失败");
            return null;
        }

        //根据openId查询用户是否之前用微信登陆过
        UserBindingLogin userBindingInfo = userBindingLoginService.findUserBindingByOpenId(wxLogin.getOpenId());

        //如果用户用微信登陆过,则查询到用户信息并返回给用户
        if(userBindingInfo != null)
        {
            return login(userBindingInfo.getUserId());
        }

        //如果没用微信登陆过,则获取用户微信个人信息,并帮用户注册,返回用户登陆信息
        wxLogin = weChatRpcService.getWxUserInfo(wxLogin.getOpenId(),wxLogin.getToken(),ProductConstants.PRODUCT_TECH);
        if(wxLogin == null)
        {
            logger.info("wxBindingLogin登陆失败");
            return null;
        }

        //注册微信用户信息
        User user = new User();
        user.setNickName(wxLogin.getNickName() +"_"+ CommonUtil.createNonceStr(3));
        user.setHeadPic(wxLogin.getHeadPic());
        user.setSex(wxLogin.getSex());
        user.setPwd(ConfigInfo.getConfigInfo().getDefaultPwd());
        userService.register(user);
        logger.info("微信用户绑定注册成功,userId={}",user.getId());

        //添加三方登陆信息关联
        UserBindingLogin userBindingLogin = new UserBindingLogin();
        userBindingLogin.setUserId(user.getId());
        userBindingLogin.setUnionId(wxLogin.getUnionId());
        userBindingLogin.setOpenId(wxLogin.getOpenId());
        userBindingLogin.setType(UserBindingLogin.TYPE_WECHAT);
        userBindingLoginService.saveUserBindingLogin(userBindingLogin);

        //登陆
        return login(user.getId());
    }

    private UserLoginVo login(int userId) {
        try {
            User user = userService.login(userId);
            if(user == null)
            {
                return null;
            }

            UserLoginVo result = (UserLoginVo)CopyBean.getBean(new UserLoginVo(),user);
            result.setUserId(user.getId());

            cacheLoginInfo(result);

            return result;
        } catch (Exception e) {
            logger.error("login={}",e);
            return null;
        }
    }

    @Override
    public int bindWeChat(int userId, String code) {
        try {
            //根据用户ID查询是否绑定
            UserBindingLogin userBinding = userBindingLoginService.findUserBindingByUserId(userId);
            if(userBinding != null)
            {
                return 2;
            }

            //根据code获取微信用户的openid
            WxLoginVo wxLogin = weChatRpcService.getOpenId(code, ProductConstants.PRODUCT_TECH);
            if(wxLogin == null)
            {
                logger.info("bindWeChat 绑定微信失败");
                return 0;
            }

            userBinding = userBindingLoginService.findUserBindingByOpenId(wxLogin.getOpenId());
            if(userBinding != null)
            {
                return 2;
            }

            userBinding = new UserBindingLogin();
            userBinding.setOpenId(wxLogin.getOpenId());

            wxLogin = weChatRpcService.getWxUserInfo(wxLogin.getOpenId(),wxLogin.getToken(), ProductConstants.PRODUCT_TECH);
            if(wxLogin == null)
            {
                logger.info("bindWeChat 绑定微信失败");
                return 0;
            }
            userBinding.setType(UserBindingLogin.TYPE_WECHAT);
            userBinding.setUnionId(wxLogin.getUnionId());
            userBinding.setUserId(userId);

            return userBindingLoginService.saveUserBindingLogin(userBinding);
        } catch (Exception e) {
            logger.error("bindWeChat={}",e);
            return 0;
        }
    }

    @Override
    public int whetherToBindWeChat(int userId) {
        //根据用户ID查询是否绑定
        UserBindingLogin userBinding = userBindingLoginService.findUserBindingByUserId(userId);
        if(userBinding != null)
        {
            return 1;
        }
        return 2;
    }

    @Override
    public List<UserTaskListVo> findUserTaskList(int userId) {

        //查询用户所有任务列表
        List<UserTask> allTaskList = userTaskService.findAllTaskList();

        //查询用户每日任务记录
        List<UserTask> userDailyTaskList = userTaskService.findUserDailyTaskList(userId);
        Set<Integer> dataDetail = new HashSet<>();
        for(UserTask userTask:userDailyTaskList)
        {
            dataDetail.add(userTask.getId());
        }

        //查询用户一次性任务记录
        List<UserTask> userOneTimeTaskList = userTaskService.findUserOneTimeTaskList(userId);
        for(UserTask userTask:userOneTimeTaskList)
        {
            dataDetail.add(userTask.getId());
        }

        //组装数据返回
        List<UserTaskListVo> resultList = new ArrayList<>();
        UserTaskListVo vo;
        for(UserTask userTask:allTaskList)
        {
            vo = new UserTaskListVo();
            vo.setTaskId(userTask.getId());
            vo.setTaskName(userTask.getName());
            vo.setTaskType(userTask.getType());
            vo.setTaskIntegral(userTask.getIntegral());
            if(dataDetail.contains(Integer.valueOf(userTask.getId())))
            {
                vo.setStatus(UserTask.STATUS_YES);
            }
            else
            {
                vo.setStatus(UserTask.STATUS_NO);
            }
            resultList.add(vo);
        }
        return resultList;
    }

    @Override
    public int doTheTask(int taskId, int userId) {
        return userTaskService.doTheTask(userId,taskId);
    }

    @Override
    public int userSign(int userId) {
        int num = userSignService.userSign(userId);
        if(num > 0)
        {
            RefreshUserThread.refreshCacheUser(userId);
        }
        return num;
    }

    @Override
    public int findUserSignStatus(int userId) {
        return userSignService.findUserSignStatus(userId);
    }

    @Override
    public int findContinuousSignDays(int userId) {

        UserSign userSign = userSignService.findUserSign(userId);

        //判断最新的签到数据是不是昨天或今天
        DateTime yestday = new DateTime();
        yestday = yestday.minusDays(1);
        DateTime nowDay = new DateTime();
        DateTime signTime = new DateTime(userSign.getSignTime());

        //判断是不是同年
        if(nowDay.getYear() != signTime.getYear())
        {
            return 0;
        }

        //判断月份
        if(yestday.getMonthOfYear() != signTime.getMonthOfYear() &&  nowDay.getMonthOfYear() != signTime.getMonthOfYear())
        {
            return 0;
        }

        //判断天
        if(yestday.getDayOfMonth() != signTime.getDayOfMonth() && nowDay.getDayOfMonth() != signTime.getDayOfMonth())
        {
            return 0;
        }

        return userSign.getContinuousSign();
    }

    @Override
    public int findMaxNum() {
        return userService.findMaxNum();
    }

    @Override
    public String bindingFaceId(int userId) {
        String faceId = userService.associateFaceId(userId);
        faceId = RsaCoder.encryptByPrivateKey(faceId);
        return faceId;
    }

    @Override
    public UserLoginVo faceLogin(String faceId) {
        try {
            faceId = RsaCoder.decryptByPrivateKey(faceId);
            if(faceId == null)
            {
                return null;
            }
            User user = userService.findUserByFaceId(faceId);
            if(user == null)
            {
                return null;
            }
            userService.modifyLoginTime(user.getId());
            UserCache cacheUser = userService.getCacheUser(user.getId());
            UserLoginVo result = (UserLoginVo)CopyBean.getBean(new UserLoginVo(),cacheUser);
            return result;
        } catch (Exception e) {
            logger.error("faceLogin",e);
            return null;
        }
    }

    @Override
    public UserInfoShowVo findUserByPhone(String phone) {
        try {
            User user = userService.findUserByPhone(phone);
            if(user == null)
            {
                return null;
            }
            UserCache cacheUser = userService.getCacheUser(user.getId());
            UserInfoShowVo result = (UserInfoShowVo)CopyBean.getBean(new UserInfoShowVo(),cacheUser);
            return result;
        } catch (Exception e) {
            logger.error("findUserByPhone",e);
            return null;
        }
    }

}

package com.wd.tech.service.impl;

import com.bw.message.ImUserServer;
import com.wd.tech.cache.RedisPool;
import com.wd.tech.cache.RedisUtil;
import com.wd.tech.dao.UserMapper;
import com.wd.tech.rpc.pojo.User;
import com.wd.tech.rpc.pojo.UserCache;
import com.wd.tech.rpc.pojo.UserSign;
import com.wd.tech.rpc.pojo.UserVip;
import com.wd.tech.rpc.vo.UserLoginVo;
import com.wd.tech.service.*;
import com.wd.tech.service.async.RefreshUserThread;
import com.wd.tech.util.*;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by xyj on 2018/8/27.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger("userService");

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserIntegralService userIntegralService;

    @Resource
    private UserVipService userVipService;

    @Resource
    private FriendGroupService friendGroupService;

    @Resource
    private UserSignService userSignService;

    @Override
    public User getUserInfoById(int userId) {
        return userMapper.getUserInfoById(userId);
    }

    @Override
    public UserCache getCacheUser(int userId) {
        try {
            RedisPool redisPool = RedisUtil.getRedisPool(RedisConstant.POOL_NAME);
            UserCache userCache = redisPool.get(String.format(RedisConstant.USER_INFO_KEY,userId), UserCache.class);
            if(userCache != null)
            {
                return userCache;
            }
            return refreshCacheUser(userId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int register(User user) {

        if (user == null)
        {
            return 0;
        }

        if(userMapper.checkNickName(user.getNickName()) > 0)
        {
            return 2;
        }

        if(userMapper.checkPhone(user.getPhone()) > 0)
        {
            return 3;
        }

        try {
            //生成环信用户名
            String userName = getHxUserName(user.getPhone());

            //处理密码
            String pwd = CommonUtil.conversionPwd(user.getPwd());
            if(pwd == null)
            {
                return 4;
            }
            user.setPwd(pwd);

            //注册环信帐号
            ImUserServer.registeUser(userName,pwd,user.getNickName());

            //注册用户
            user.setUserName(userName);

            //头像处理
            if(user.getHeadPic() == null)
            {
                user.setHeadPic(ConfigInfo.getConfigInfo().getHeadUrl());
            }

            //性别处理
            if(user.getSex() == 0)
            {
                user.setSex(1);
            }

            userMapper.addUser(user);

            //初始化用户好友
            friendGroupService.initFriendGroup(user.getId());

            //将用户信息放入到缓存
            RefreshUserThread.refreshCacheUser(user.getId());

            return 1;
        } catch (Exception e) {
            logger.error("register",e);
            return 0;
        }
    }

    @Override
    public UserLoginVo login(String phone, String pwd) {
        try {
            pwd = CommonUtil.conversionPwd(pwd);
            User user = userMapper.login(phone, pwd);
            if(user == null)
            {
                return null;
            }
            userMapper.modifyLoginTime(user.getId());
            UserLoginVo result = (UserLoginVo)CopyBean.getBean(new UserLoginVo(),user);
            result.setUserId(user.getId());
            return result;
        } catch (Exception e) {
            logger.error("login",e);
            return null;
        }
    }

    @Override
    public User login(int userId) {
        User user = userMapper.getUserInfoById(userId);
        if(user == null)
        {
            return null;
        }
        userMapper.modifyLoginTime(user.getId());
        return user;
    }

    @Override
    public int modifyNickName(int userId, String nickName) {
        try {
            if(userMapper.checkNickName(nickName) > 0)
            {
                return 2;
            }
            int num = userMapper.modifyNickName(userId, nickName);
            RefreshUserThread.refreshCacheUser(userId);
            return num;
        } catch (Exception e) {
            logger.error("modifyNickName",e);
            return 0;
        }
    }

    @Override
    public int modifySignature(int userId, String signature) {
        try {
            int num = userMapper.modifySignature(userId,signature);
            RefreshUserThread.refreshCacheUser(userId);
            return num;
        } catch (Exception e) {
            logger.error("modifySignature",e);
            return 0;
        }
    }

    @Override
    public int modifyHeadPic(int userId, String headPic) {
        try {
            int num = userMapper.modifyHeadPic(userId, headPic);
            RefreshUserThread.refreshCacheUser(userId);
            return num;
        } catch (Exception e) {
            logger.error("modifyHeadPic",e);
            return 0;
        }
    }

    @Override
    public int modifyEmail(int userId, String email) {
        try {
            int num = userMapper.modifyEmail(userId, email);
            RefreshUserThread.refreshCacheUser(userId);
            return num;
        } catch (Exception e) {
            logger.error("modifyEmail",e);
            return 0;
        }
    }

    @Override
    public int modifyUserPwd(int userId, String newPwd, String oldPwd) {
        try {
            newPwd = CommonUtil.conversionPwd(newPwd);
            oldPwd = CommonUtil.conversionPwd(oldPwd);
            if(newPwd == null || oldPwd == null)
            {
                return 0;
            }
            int num = userMapper.updateUserPwd(userId,newPwd,oldPwd);
            if(num > 0)
            {
                UserCache cacheUser = getCacheUser(userId);
                //同步修改环信用户密码
                ImUserServer.updatePwd(cacheUser.getUserName(),newPwd);
            }
            RefreshUserThread.refreshCacheUser(userId);
            return num;
        } catch (Exception e) {
            logger.error("modifyUserPwd",e);
            return 0;
        }
    }

    @Override
    public int checkPhone(String phone) {
        try {
            return userMapper.checkPhone(phone);
        } catch (Exception e) {
            logger.error("checkPhone",e);
            return 0;
        }
    }

    @Override
    public int checkNickName(String nickName) {
        try {
            return userMapper.checkNickName(nickName);
        } catch (Exception e) {
            logger.error("checkNickName",e);
            return 0;
        }
    }

    @Override
    public UserCache refreshCacheUser(int userId) {
        try {
            //缓存用户个人信息
            User user = userMapper.getUserInfoById(userId);
            if(user == null)
            {
                return null;
            }
            UserCache userCache = (UserCache)CopyBean.getBean(new UserCache(),user);
            userCache.setUserId(userId);

            //缓存积分
            int integralNum = userIntegralService.findIntegralNum(userId);
            userCache.setIntegral(integralNum);

            //缓存会员信息
            UserVip userVip = userVipService.getUserVip(userId);
            if(userVip == null)
            {
                userCache.setWhetherVip(UserVip.VIP_NO);
            }
            else
            {
                //先判断VIP是否已到期
                DateTime nowTime = new DateTime();
                DateTime expireTime = new DateTime(userVip.getExpire());
                boolean after = nowTime.isAfter(expireTime);
                if(after)
                {
                    userCache.setWhetherVip(UserVip.VIP_NO);
                }
                else
                {
                    userCache.setWhetherVip(UserVip.VIP_YES);
                    userCache.setVipExpireDate(userVip.getExpire());
                }
            }

            //处理是否绑定faceId
            userCache.setWhetherFaceId(user.getFaceId() != null ? 1:2);

            RedisPool redisPool = RedisUtil.getRedisPool(RedisConstant.POOL_NAME);
            String key = String.format(RedisConstant.USER_INFO_KEY,userId);
            redisPool.set(key,userCache);
            redisPool.expire(key,2592000);

            return userCache;
        } catch (Exception e) {
            logger.error("refreshCacheUser",e);
            return null;
        }
    }

    @Override
    public int perfectUserInfo(int userId,String nickName, int sex, String signature, Date birthday, String email) {
        try {
            User user = new User();
            user.setId(userId);
            user.setNickName(nickName);
            user.setSex(sex);
            user.setSignature(signature);
            user.setBirthday(birthday);
            user.setEmail(email);
            userMapper.perfectUserInfo(user);
            RefreshUserThread.refreshCacheUser(userId);
            return 1;
        } catch (Exception e) {
            logger.error("perfectUserInfo",e);
            return 0;
        }
    }

    @Override
    public List<User> findUserByUserNames(List<String> list) {
        return userMapper.findUserByUserNames(list);
    }

    @Override
    public int userSign(int userId) {
        return userSignService.userSign(userId);
    }

    @Override
    public int findUserSignStatus(int userId) {
        return userSignService.findUserSignStatus(userId);
    }

    @Override
    public UserSign findUserSign(int userId) {
        return userSignService.findUserSign(userId);
    }

    @Override
    public int findMaxNum() {
        return userMapper.findMaxNum();
    }

    @Override
    public String associateFaceId(int userId) {
        try {
            String faceId = CommonUtil.createNonceStr(10);
            faceId = faceId + userId;
            userMapper.modifyFaceId(userId,faceId);
            refreshCacheUser(userId);
            return faceId;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User findUserByFaceId(String faceId) {
        return userMapper.findUserByFaceId(faceId);
    }

    @Override
    public int modifyLoginTime(int userId) {
        return userMapper.modifyLoginTime(userId);
    }

    @Override
    public User findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    /**
     *  获取环信用户名
     * @param phone
     * @return
     */
    private String getHxUserName(String phone)
    {
        StringBuffer sb = new StringBuffer();
        if(phone == null)
        {
            sb.append(CommonUtil.create_nonce_str(17));
        }
        else
        {
            sb.append(CommonUtil.create_nonce_str(6));
            sb.append(phone);
        }
        return sb.toString();
    }

    /**
     *  获取明文密码
     * @param pwd
     * @return
     */
    private String getUserPwd(String pwd)
    {
        return RsaCoder.decryptByPrivateKey(pwd);
    }

    /**
     *  私钥加密
     * @param pwd
     * @return
     */
    private String encryption(String pwd)
    {
        return RsaCoder.encryptByPrivateKey(pwd);
    }

}

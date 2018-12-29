package com.wd.tech.service;

import com.wd.base.BaseTest;
import com.wd.tech.rpc.pojo.User;
import com.wd.tech.util.RsaCoder;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xyj on 2018/8/27.
 */
@Ignore
public class UserServiceTest extends BaseTest{

    @Resource
    private UserService userService;

    @Test
    public void register()throws Exception
    {
        User user  = new User();
        user.setNickName("你好3");
        user.setPwd(RsaCoder.encryptByPublicKey("123456"));
        user.setPhone("18600151567");
        userService.register(user);
    }

    @Test
    public void login()throws Exception
    {
        System.out.println(userService.login("18600151565",RsaCoder.encryptByPublicKey("123456")));
    }

    @Test
    public void findConversationList()throws Exception
    {
        String arg = "yichenfeng,OtuU4L18600151567";
        String [] temps = arg.split(",");
        List<String> list = Arrays.asList(temps);
        System.out.println(userService.findUserByUserNames(list));
    }

    @Test
    public void refreshCacheUser()throws Exception
    {
        System.out.println(userService.refreshCacheUser(1007));
    }

    @Test
    public void associateFaceId()throws Exception
    {
        System.out.println(userService.associateFaceId(1016));
    }

    @Test
    public void findUserByFaceId()throws Exception
    {
        System.out.println(userService.findUserByFaceId("D4uVy85YuC1016"));
    }

}
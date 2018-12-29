package com.wd.tech.service.async;

import com.wd.tech.service.UserService;
import com.wd.tech.util.SpringUtil;

/**
 * Created by xyj on 2018/9/25.
 */
public class RefreshUserThread implements Runnable {

    private int userId;

    public RefreshUserThread(){}

    public RefreshUserThread(int userId)
    {
            this.userId = userId;
    }

    @Override
    public void run() {
        UserService userService = (UserService)SpringUtil.getBean("userService");
        userService.refreshCacheUser(this.userId);
    }

    /**
     *  异步刷新用户缓存
     * @param userId
     */
    public static void refreshCacheUser(int userId)
    {
        Thread thread = new Thread(new RefreshUserThread(userId));
        thread.start();
    }

}

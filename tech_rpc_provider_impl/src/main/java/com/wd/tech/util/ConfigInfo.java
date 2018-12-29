package com.wd.tech.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by xyj on 2018/1/11.
 */
public class ConfigInfo {

    private static ConfigInfo configInfo;

    private static long last_reload_time = 0;

    private static boolean isReload()
    {
        long nowTime = new Date().getTime();
        if((nowTime - last_reload_time) > 5000)
        {
            last_reload_time = nowTime;
            return true;
        }
        return false;
    }

    private String headUrl;
    private String defaultPwd;

    public String getHeadUrl() {
        return headUrl;
    }

    public String getDefaultPwd() {
        return defaultPwd;
    }

    public void setDefaultPwd(String defaultPwd) {
        this.defaultPwd = defaultPwd;
    }

    public static ConfigInfo getConfigInfo()
    {
        if(configInfo == null)
        {
            configInfo  = new ConfigInfo();
            initInfo();
        }
        if(isReload())
        {
            initInfo();
        }
        return configInfo;
    }

    private static void initInfo()
    {
        try {
            Properties p = PropertiesUtil.getProperties("properties/config_info.properties","utf-8");
            configInfo.headUrl = p.getProperty("head_url");
            configInfo.defaultPwd = p.getProperty("default_pwd");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

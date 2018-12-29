package com.wd.tech.service;


import com.wd.tech.rpc.pojo.AppVersion;

/**
 * Created by xyj on 2018/7/18.
 */
public interface AppVersionService {

    /**
     * 查询最新AK
     * @return
     */
    AppVersion findNewAk();

}

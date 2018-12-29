package com.wd.tech.service.impl;

import com.wd.tech.dao.AppVersionMapper;
import com.wd.tech.rpc.pojo.AppVersion;
import com.wd.tech.service.AppVersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/7/18.
 */
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService {

    @Resource
    private AppVersionMapper appVersionMapper;

    @Override
    public AppVersion findNewAk() {
        return appVersionMapper.findNewAk();
    }
}

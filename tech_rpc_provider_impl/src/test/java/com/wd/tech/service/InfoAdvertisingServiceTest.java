package com.wd.tech.service;

import com.wd.base.BaseTest;
import com.wd.tech.rpc.pojo.InfoAdvertising;
import com.wd.tech.rpc.vo.InfoAdvertisingVo;
import org.junit.Ignore;

import javax.annotation.Resource;

@Ignore
public class InfoAdvertisingServiceTest extends BaseTest {

    @Resource
    private InfoAdvertisingService infoAdvertisingService;

    @org.junit.Test
    public void findInfoAdvertising() {
        InfoAdvertisingVo infoAdvertising = infoAdvertisingService.findInfoAdvertising();
        System.out.println(infoAdvertising);
    }
}
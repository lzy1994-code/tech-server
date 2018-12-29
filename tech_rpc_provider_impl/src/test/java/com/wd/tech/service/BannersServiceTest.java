package com.wd.tech.service;

import com.wd.base.BaseTest;
import com.wd.tech.rpc.pojo.Banners;
import com.wd.tech.rpc.vo.BannersVo;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

@Ignore
public class BannersServiceTest extends BaseTest {


    @Resource
    private BannersService bannersService;

    @Test
    public void bannerShow() {
        List<BannersVo> bannersVos = bannersService.bannerShow();
        System.out.println(bannersVos);
    }
}
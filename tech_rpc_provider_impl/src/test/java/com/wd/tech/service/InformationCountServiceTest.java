package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

@Ignore
public class InformationCountServiceTest extends BaseTest {

    @Resource
    private InformationCountService informationCountService;

    @Test
    public void updateInfoShareNum() {
        informationCountService.updateInfoShareNum(1);
    }
}
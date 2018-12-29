package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by xyj on 2018/9/30.
 */
@Ignore
public class CommodityServiceTest extends BaseTest {

    @Resource
    private CommodityService commodityService;

    @Test
    public void findAllByType() {

        System.out.println(commodityService.findAllByType(1));

    }

    @Test
    public void getCommodity() {

        System.out.println(commodityService.getCommodity(1001));

    }
}
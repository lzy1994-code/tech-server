package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

@Ignore
public class InfoGreatServiceTest extends BaseTest {

   @Resource
    private InfoGreatService infoGreatService;
    @Test
    public void addGreatRecord() {
        boolean b = infoGreatService.addGreatRecord(1002, 4);
        System.out.println(b);
    }
}
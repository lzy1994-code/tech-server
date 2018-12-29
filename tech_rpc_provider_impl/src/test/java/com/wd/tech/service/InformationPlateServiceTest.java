package com.wd.tech.service;

import com.wd.base.BaseTest;
import com.wd.tech.rpc.pojo.InformationPlate;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

@Ignore
public class InformationPlateServiceTest extends BaseTest {

    @Resource
    private InformationPlateService informationPlateService;

    @Test
    public void findAllInfoPlate() {
        List<InformationPlate> allInfoPlate = informationPlateService.findAllInfoPlate();
        System.out.println(allInfoPlate);
    }
}
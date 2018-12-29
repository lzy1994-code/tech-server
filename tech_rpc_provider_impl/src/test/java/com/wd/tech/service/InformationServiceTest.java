package com.wd.tech.service;

import com.wd.base.BaseTest;
import com.wd.tech.rpc.vo.InformationListVo;
import com.wd.tech.rpc.vo.InformationVagueVo;
import com.wd.tech.rpc.vo.InformationVo;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

@Ignore
public class InformationServiceTest extends BaseTest {
   @Resource
   private InformationService informationService;
    @Test
    public void infoRecommendList() {
      List<InformationListVo> list = informationService.infoRecommendList(0,0,1,10);
        System.out.println(list);
    }

    @Test
    public void findInformationDetails() {
        InformationVo information = informationService.findInformationDetails(0,3);
        System.out.println(information);
    }
    @Test
    public void findInformationByTitle(){
        List<InformationVagueVo> informationByTitle = informationService.findInformationByTitle("滴",1,5);
        System.out.println(informationByTitle);
    }

}
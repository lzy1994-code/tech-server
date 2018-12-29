package com.wd.tech.service.impl;

import com.wd.tech.dao.InfoAdvertisingMapper;
import com.wd.tech.rpc.pojo.InfoAdvertising;
import com.wd.tech.rpc.vo.InfoAdvertisingVo;
import com.wd.tech.service.InfoAdvertisingService;
import com.wd.tech.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;


/**
 * @program: tech-rpc
 * @description: 资讯广告实现
 * @author: Lzy
 * @create: 2018-09-04 08:31
 **/
@Service("infoAdvertisingService")
public class InfoAdvertisingServiceImpl implements InfoAdvertisingService{
    private Logger logger = LoggerFactory.getLogger(InfoAdvertisingService.class);
    @Resource
    private InfoAdvertisingMapper infoAdvertisingMapper;


    @Override
    public InfoAdvertisingVo findInfoAdvertising() {
        InfoAdvertising infoAdvertising = new InfoAdvertising() ;
        InfoAdvertisingVo infoAdvertisingVo = new InfoAdvertisingVo();
        List<InfoAdvertising> infoAdvertisingList = infoAdvertisingMapper.findInfoAdvertisingList();
        Random random = new Random();
        int weightSum = 0;
        for (InfoAdvertising infoAd:infoAdvertisingList) {
            weightSum += infoAd.getWeight();
        }
        if (weightSum<=0){
            logger.error("Error: weightSum=" + weightSum);
            return null;
        }
        int n =  random.nextInt(weightSum);
        int m = 0;
        for (InfoAdvertising infoAd:infoAdvertisingList) {
            if (m <= n && n < m + infoAd.getWeight()){
                infoAdvertising = infoAd;
            }
            m += infoAd.getWeight();
        }
        infoAdvertisingVo.setId(infoAdvertising.getId());
        infoAdvertisingVo.setPic(infoAdvertising.getPic());
        infoAdvertisingVo.setUrl(infoAdvertising.getUrl());
        infoAdvertisingVo.setContent(infoAdvertising.getContent());
        return infoAdvertisingVo;
    }
}

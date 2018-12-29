package com.wd.tech.service.impl;

import com.wd.tech.dao.InformationCountMapper;
import com.wd.tech.service.InformationCountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: tech-rpc
 * @description: 资讯信息统计实现类
 * @author: Lzy
 * @create: 2018-08-29 15:30
 **/
@Service("informationCountService")
public class InformationCountServiceImpl implements InformationCountService {

    @Resource
    private InformationCountMapper informationCountMapper;

    @Override
    public boolean updateInfoShareNum(int infoId) {
        return  informationCountMapper.updateInfoShareNum(infoId);
    }
}

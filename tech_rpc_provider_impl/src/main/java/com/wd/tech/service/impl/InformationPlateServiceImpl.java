package com.wd.tech.service.impl;

import com.wd.tech.dao.InformationPlateMapper;
import com.wd.tech.rpc.pojo.InformationPlate;
import com.wd.tech.service.InformationPlateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 资讯板块实现类
 * @author: Lzy
 * @create: 2018-08-30 16:58
 **/
@Service("informationPlateService")
public class InformationPlateServiceImpl implements InformationPlateService{
    @Resource
    private InformationPlateMapper informationPlateMapper;
    /**
     * 所有板块查询
     * @return
     */
    @Override
    public List<InformationPlate> findAllInfoPlate() {
        return informationPlateMapper.findAllInfoPlate();
    }
}

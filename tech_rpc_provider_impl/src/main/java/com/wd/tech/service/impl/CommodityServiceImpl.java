package com.wd.tech.service.impl;

import com.wd.tech.dao.CommodityMapper;
import com.wd.tech.rpc.pojo.Commodity;
import com.wd.tech.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xyj on 2018/9/25.
 */
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    @Resource
    private CommodityMapper commodityMapper;

    @Override
    public List<Commodity> findAllByType(int type) {
        return commodityMapper.findAllByType(type);
    }

    @Override
    public Commodity getCommodity(int id) {
        return commodityMapper.getCommodity(id);
    }

}

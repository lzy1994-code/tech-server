package com.wd.tech.service;

import com.wd.tech.rpc.pojo.Commodity;

import java.util.List;

/**
 * Created by xyj on 2018/9/25.
 */
public interface CommodityService {

    List<Commodity> findAllByType(int type);

    Commodity getCommodity(int id);

}

package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.Commodity;

import java.util.List;

/**
 * Created by xyj on 2018/9/25.
 */
public interface CommodityMapper {

    List<Commodity> findAllByType(int type);

    Commodity getCommodity(int id);

}

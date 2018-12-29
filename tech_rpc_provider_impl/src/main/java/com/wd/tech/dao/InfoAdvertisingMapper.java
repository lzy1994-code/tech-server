package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.InfoAdvertising;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 资讯广告
 * @author: Lzy
 * @create: 2018-09-03 17:46
 **/
public interface InfoAdvertisingMapper {

    /**
     * 广告列表
     * @return
     */
    List<InfoAdvertising> findInfoAdvertisingList();


}

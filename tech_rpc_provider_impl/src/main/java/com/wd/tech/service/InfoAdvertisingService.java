package com.wd.tech.service;

import com.wd.tech.rpc.pojo.InfoAdvertising;
import com.wd.tech.rpc.vo.InfoAdvertisingVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 资讯广告
 * @author: Lzy
 * @create: 2018-09-04 08:24
 **/
public interface InfoAdvertisingService {


    /**
     * 广告列表
     * @return
     */
    InfoAdvertisingVo findInfoAdvertising();

}

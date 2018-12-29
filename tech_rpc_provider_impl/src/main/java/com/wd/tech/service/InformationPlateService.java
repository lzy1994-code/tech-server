package com.wd.tech.service;

import com.wd.tech.rpc.pojo.InformationPlate;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 资讯板块service
 * @author: Lzy
 * @create: 2018-08-30 16:58
 **/
public interface InformationPlateService {
    /**
     * 所有板块查询
     * @return
     */
    List<InformationPlate> findAllInfoPlate();
}

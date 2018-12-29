package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.InformationPlate;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 资讯板块
 * @author: Lzy
 * @create: 2018-08-30 15:46
 **/
public interface InformationPlateMapper {

    /**
     * 查询板块名称(用于资讯详情展示)
     * @param infoId
     * @return
     */
    List<InformationPlate> findPlateNameById(int infoId);

    /**
     * 所有板块查询
     * @return
     */
    List<InformationPlate> findAllInfoPlate();

}

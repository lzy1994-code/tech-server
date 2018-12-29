package com.wd.tech.service;

/**
 * @program: tech-rpc
 * @description: 资讯信息统计service
 * @author: Lzy
 * @create: 2018-08-29 15:29
 **/
public interface InformationCountService {


    /**
     * 修改资讯分享数
     * @param infoId
     */
    boolean updateInfoShareNum(int infoId);


}

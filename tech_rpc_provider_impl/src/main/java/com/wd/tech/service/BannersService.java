package com.wd.tech.service;

import com.wd.tech.rpc.pojo.Banners;
import com.wd.tech.rpc.vo.BannersVo;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: banner
 * @author: Lzy
 * @create: 2018-09-01 09:34
 **/
public interface BannersService {

    /**
     * banner展示列表
     */
    List<BannersVo> bannerShow();

}

package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.Banners;
import com.wd.tech.rpc.vo.BannersVo;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: banner
 * @author: Lzy
 * @create: 2018-09-01 09:22
 **/
public interface BannersMapper {

    /**
     * banner展示列表
     */
    List<BannersVo> bannerShow();

}

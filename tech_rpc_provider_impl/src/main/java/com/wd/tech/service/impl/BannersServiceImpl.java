package com.wd.tech.service.impl;

import com.wd.tech.dao.BannersMapper;
import com.wd.tech.rpc.pojo.Banners;
import com.wd.tech.rpc.vo.BannersVo;
import com.wd.tech.service.BannersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: banner
 * @author: Lzy
 * @create: 2018-09-01 09:35
 **/
@Service("bannersService")
public class BannersServiceImpl implements BannersService {

    @Resource
    private BannersMapper bannersMapper;

    @Override
    public List<BannersVo> bannerShow() {
        return bannersMapper.bannerShow();
    }
}

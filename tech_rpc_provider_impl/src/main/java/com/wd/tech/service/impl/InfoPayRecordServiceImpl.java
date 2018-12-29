package com.wd.tech.service.impl;

import com.wd.tech.dao.InfoPayRecordMapper;
import com.wd.tech.rpc.vo.InfoPayRecordVo;
import com.wd.tech.service.InfoPayRecordService;
import com.wd.tech.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户资讯支付
 * @author: Lzy
 * @create: 2018-09-04 14:39
 **/
@Service("infoPayRecordService")
public class InfoPayRecordServiceImpl implements InfoPayRecordService {

    @Resource
    private InfoPayRecordMapper infoPayRecordMapper;

    @Override
    public List<InfoPayRecordVo> findUserPayList(int userId, int page, int count) {
        return infoPayRecordMapper.findUserPayList(userId, CommonUtil.getPageIndex(page,count),count);
    }
}

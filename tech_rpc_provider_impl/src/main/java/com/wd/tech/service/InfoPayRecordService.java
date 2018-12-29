package com.wd.tech.service;

import com.wd.tech.rpc.pojo.InfoPayRecord;
import com.wd.tech.rpc.vo.InfoPayRecordVo;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户资讯支付
 * @author: Lzy
 * @create: 2018-09-04 14:03
 **/
public interface InfoPayRecordService {

    List<InfoPayRecordVo> findUserPayList(int userId, int page, int count);

}

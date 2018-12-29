package com.wd.tech.service.impl;

import com.wd.tech.dao.SysNoticeMapper;
import com.wd.tech.rpc.pojo.SysNotice;
import com.wd.tech.service.SysNoticeService;
import com.wd.tech.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xyj on 2018/9/7.
 */
@Service("sysNoticeService")
public class SysNoticeServiceImpl implements SysNoticeService {

    @Resource
    private SysNoticeMapper sysNoticeMapper;

    @Override
    public int addSysNotice(int receiveUid, String content) {
        SysNotice sysNotice = new SysNotice();
        sysNotice.setReceiveUid(receiveUid);
        sysNotice.setContent(content);
        return sysNoticeMapper.addSysNotice(sysNotice);
    }

    @Override
    public int batchAddSysNotice(List<SysNotice> list) {
        return sysNoticeMapper.batchAddSysNotice(list);
    }

    @Override
    public List<SysNotice> findSysNoticeList(int userId,int page,int count) {
        return sysNoticeMapper.findSysNoticeList(userId, CommonUtil.getPageIndex(page, count),count);
    }
}

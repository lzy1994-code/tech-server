package com.wd.tech.service;

import com.wd.tech.rpc.pojo.SysNotice;

import java.util.List;

/**
 * Created by xyj on 2018/9/7.
 */
public interface SysNoticeService {

    int addSysNotice(int receiveUid,String content);

    int batchAddSysNotice(List<SysNotice> list);

    List<SysNotice> findSysNoticeList(int userId,int page,int count);

}

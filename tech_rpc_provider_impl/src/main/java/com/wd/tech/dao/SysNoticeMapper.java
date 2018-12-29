package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.SysNotice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/9/7.
 */
public interface SysNoticeMapper {

    int addSysNotice(SysNotice sysNotice);

    int batchAddSysNotice(List<SysNotice> list);

    List<SysNotice> findSysNoticeList(@Param("userId") int userId,@Param("index") int index,@Param("count") int count);

}

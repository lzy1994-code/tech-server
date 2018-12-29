package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.GroupNotice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/9/5.
 */
public interface GroupNoticeMapper {

    int addGroupNotice(GroupNotice groupNotice);

    List<GroupNotice> findGroupNoticePageList(@Param("userId") int userId,@Param("index") int index,@Param("count") int count);

    int updateBatchStatus(@Param("batchNumber")String batchNumber,@Param("status")int status);

    int updateStatus(@Param("noticeId")int noticeId,@Param("status")int status);

    GroupNotice findLastGroupNotice(int userId);

    GroupNotice getGroupNoticeById(int noticeId);

    int batchAddGroupNotice(List<GroupNotice> list);

    int deleteByGroupId(int groupId);
}

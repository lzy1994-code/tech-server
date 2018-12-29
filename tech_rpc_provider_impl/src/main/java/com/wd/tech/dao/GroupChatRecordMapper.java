package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.GroupChatRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/9/5.
 */
public interface GroupChatRecordMapper {

    int addGroupChatRecord(GroupChatRecord groupChatRecord);

    List<GroupChatRecord> findGroupChatRecordPage(@Param("groupId") int groupId,@Param("index") int index,@Param("count") int count);

    int deleteGroupChatRecord(int groupId);

}

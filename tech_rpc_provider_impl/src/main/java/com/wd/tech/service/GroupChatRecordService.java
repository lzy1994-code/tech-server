package com.wd.tech.service;

import com.wd.tech.rpc.pojo.GroupChatRecord;

import java.util.List;

/**
 * Created by xyj on 2018/9/5.
 */
public interface GroupChatRecordService {

    int increaseGroupChatRecord(int groupId,int userId,String content,String headPic,String chatImage);

    List<GroupChatRecord> findGroupChatRecordPage(int groupId,int page,int count);

    int deleteGroupChatRecord(int groupId);

}

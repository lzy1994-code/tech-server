package com.wd.tech.service.impl;

import com.wd.tech.dao.GroupChatRecordMapper;
import com.wd.tech.rpc.pojo.GroupChatRecord;
import com.wd.tech.rpc.pojo.User;
import com.wd.tech.service.GroupChatRecordService;
import com.wd.tech.service.UserService;
import com.wd.tech.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by xyj on 2018/9/5.
 */
@Service("groupChatRecordService")
public class GroupChatRecordServiceImpl implements GroupChatRecordService {

    @Resource
    private GroupChatRecordMapper groupChatRecordMapper;

    @Resource
    private UserService userService;

    @Override
    public int increaseGroupChatRecord(int groupId, int userId, String content,String headPic,String chatImage) {
        GroupChatRecord groupChatRecord = new GroupChatRecord();
        User userInfoById = userService.getUserInfoById(userId);
        groupChatRecord.setNickName(userInfoById.getNickName());
        groupChatRecord.setChatContent(content);
        groupChatRecord.setChatTime(new Date());
        groupChatRecord.setGroupId(groupId);
        groupChatRecord.setHeadPic(headPic);
        groupChatRecord.setUserId(userId);
        groupChatRecord.setChatImage(chatImage);
        return groupChatRecordMapper.addGroupChatRecord(groupChatRecord);
    }

    @Override
    public List<GroupChatRecord> findGroupChatRecordPage(int groupId, int page, int count) {
        return groupChatRecordMapper.findGroupChatRecordPage(groupId, CommonUtil.getPageIndex(page,count),count);
    }

    @Override
    public int deleteGroupChatRecord(int groupId) {
        return groupChatRecordMapper.deleteGroupChatRecord(groupId);
    }
}

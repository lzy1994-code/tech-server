package com.wd.tech.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bw.message.ImGroupServer;
import com.bw.util.Response;
import com.wd.tech.dao.GroupMapper;
import com.wd.tech.rpc.pojo.*;
import com.wd.tech.service.*;
import com.wd.tech.util.ConfigInfo;
import com.wd.tech.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyj on 2018/9/4.
 */
@Service("groupService")
public class GroupServiceImpl implements GroupService {

    private Logger logger = LoggerFactory.getLogger("groupService");

    @Resource
    private GroupMapper groupMapper;

    @Resource
    private UserService userService;

    @Resource
    private GroupMemberService groupMemberService;

    @Resource
    private GroupChatRecordService groupChatRecordService;

    @Resource
    private SysNoticeService sysNoticeService;

    @Resource
    private GroupNoticeService groupNoticeService;

    @Override
    public int createGroup(String name, String description, int ownerUid, int maxCount) {
        try {
            //同一用户创建的群组名称不能重复
            if(groupMapper.checkGroupName(name,ownerUid) > 0)
            {
                return 2;
            }

            //环信创建群组
            User user = userService.getUserInfoById(ownerUid);
            String groupId = getGroupId(name, description, user.getUserName() , maxCount);

            //创建群组
            Groups groups = new Groups();
            groups.setName(name);
            groups.setHxGroupId(groupId);
            groups.setCurrentCount(0);
            groups.setMaxCount(maxCount);
            groups.setDescription(description);
            groups.setOwnerUid(ownerUid);
            //默认头像
            groups.setImage(ConfigInfo.getConfigInfo().getHeadUrl());
            groupMapper.addGroup(groups);

            //插入群组创建人信息
            groupMemberService.increaseGroupMember(groups.getId(),ownerUid, GroupMember.ROLE_FOUNDER);

            return groups.getId();
        } catch (Exception e) {
            logger.error("createGroup",e);
            return 0;
        }

    }

    @Override
    public int modifyGroupName(int id, String groupName) {
        return groupMapper.modifyGroupName(id, groupName);
    }

    @Override
    public int modifyGroupDescription(int id, String description) {
        return groupMapper.modifyGroupDescription(id, description);
    }

    @Override
    public int modifyGroupUserNumber(int id, int num) {
        return groupMapper.modifyGroupUserNumber(id, num);
    }

    @Override
    public int disbandGroup(int id,int userId) {

        try {
            //判断是否为群组创建人
            Groups group = groupMapper.getGroupById(id);
            if(group.getOwnerUid() != userId)
            {
                return 2;
            }

            //删除群组信息
            groupMapper.deleteGroup(id);

            //删除环信群组记录
            ImGroupServer.deleteGroup(group.getHxGroupId());

            //发送系统通知给群内所有用户
            List<GroupMember> allGroupMember = groupMemberService.findAllGroupMember(id);
            SysNotice notice;
            List<SysNotice> list = new ArrayList<>();
            String content = String.format(Constants.GROUP_DISBAND_NOTICE,group.getName());
            for(GroupMember member:allGroupMember)
            {
                notice = new SysNotice();
                notice.setReceiveUid(member.getUserId());
                notice.setContent(content);
                list.add(notice);
            }
            sysNoticeService.batchAddSysNotice(list);

            //删除群组用户信息
            groupMemberService.deleteAllGroupMember(id);

            //删除群组聊天记录
            groupChatRecordService.deleteGroupChatRecord(id);

            //删除群组相关的群通知记录
            groupNoticeService.deleteByGroupId(id);

            return 1;
        } catch (Exception e) {
            logger.error("disbandGroup",e);
            return 0;
        }
    }

    @Override
    public List<Groups> findGroupsByUserId(int userId) {
        return groupMapper.findGroupsByUserId(userId);
    }

    @Override
    public List<Groups> findUserJoinedGroup(int userId) {
        return groupMapper.findUserJoinedGroup(userId);
    }

    @Override
    public Groups getGroupById(int id) {
        return groupMapper.getGroupById(id);
    }

    @Override
    public int getGroupCurrentCount(int id) {
        return groupMapper.getGroupCurrentCount(id);
    }

    @Override
    public int modifyImage(String image, int groupId) {
        return groupMapper.modifyImage(image,groupId);
    }

    private String getGroupId(String name, String description, String userName, int maxCount)
    {
        Response response = ImGroupServer.increaseGroup(name, description, maxCount, userName);
        JSONObject jsonObject = JSONObject.parseObject(String.valueOf(response.getT()));
        return jsonObject.getJSONObject("data").getString("groupid");
    }

}

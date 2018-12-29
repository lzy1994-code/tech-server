package com.wd.tech.rpc.impl;

import com.wd.tech.rpc.api.GroupRpcService;
import com.wd.tech.rpc.pojo.*;
import com.wd.tech.rpc.vo.*;
import com.wd.tech.service.*;
import com.wd.tech.util.Constants;
import com.wd.tech.util.RsaCoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyj on 2018/9/6.
 */
@Service("groupRpcService")
public class GroupRpcServiceImpl implements GroupRpcService {

    private Logger logger = LoggerFactory.getLogger("groupRpcService");

    @Resource
    private GroupService groupService;

    @Resource
    private UserService userService;

    @Resource
    private GroupMemberService groupMemberService;

    @Resource
    private GroupChatRecordService groupChatRecordService;

    @Resource
    private GroupNoticeService groupNoticeService;

    @Override
    public int createGroup(String name, String description, int userId) {
        try {
            UserCache userCache = userService.getCacheUser(userId);
            int max = Constants.VIP_GROUP_MAX_NUMBER_NO;
            if(userCache.getWhetherVip() == UserVip.VIP_YES)
            {
                max = Constants.VIP_GROUP_MAX_NUMBER_YES;
            }
            return groupService.createGroup(name,description,userId,max);
        } catch (Exception e) {
            logger.error("createGroup",e);
            return 0;
        }
    }

    @Override
    public int modifyGroupName(int groupId, String groupName) {
        try {
            return groupService.modifyGroupName(groupId, groupName);
        } catch (Exception e) {
            logger.error("modifyGroupName",e);
            return 0;
        }
    }

    @Override
    public int modifyGroupDescription(int groupId, String description) {
        try {
            return groupService.modifyGroupDescription(groupId, description);
        } catch (Exception e) {
            logger.error("modifyGroupDescription",e);
            return 0;
        }
    }

    @Override
    public int disbandGroup(int groupId, int userId) {
        try {
            return groupService.disbandGroup(groupId, userId);
        } catch (Exception e) {
            logger.error("disbandGroup",e);
            return 0;
        }
    }

    @Override
    public List<GroupListVo> findGroupsByUserId(int userId) {
        List<Groups> list = groupService.findGroupsByUserId(userId);
        if(list == null)
        {
            return new ArrayList<>();
        }

        return getGroupListVos(list,userId);
    }

    private List<GroupListVo> getGroupListVos(List<Groups> list,int userId) {
        GroupListVo vo;
        List<GroupListVo> result = new ArrayList<>();
        for (Groups temp : list) {
            //新增用户角色
            int userRole = groupMemberService.findUserRole(userId, temp.getId());
            vo = new GroupListVo();
            vo.setGroupId(temp.getId());
            vo.setGroupImage(temp.getImage());
            vo.setGroupName(temp.getName());
            vo.setHxGroupId(temp.getHxGroupId());
            vo.setRole(userRole);
            result.add(vo);
        }
        return result;
    }

    @Override
    public List<GroupListVo> findUserJoinedGroup(int userId) {

        List<Groups> list = groupService.findUserJoinedGroup(userId);
        if(list == null)
        {
            return new ArrayList<>();
        }

        return getGroupListVos(list,userId);

    }

    @Override
    public List<GroupMemberListVo> findGroupMemberList(int groupId) {

        List<GroupMember> list = groupMemberService.findAllGroupMember(groupId);
        if(list == null)
        {
            return new ArrayList<>();
        }

        List<GroupMemberListVo> result = new ArrayList<>();
        GroupMemberListVo vo;
        UserCache userCache;
        for(GroupMember temp:list)
        {
            userCache = userService.getCacheUser(temp.getUserId());
            vo = new GroupMemberListVo();
            vo.setUserId(temp.getUserId());
            vo.setHeadPic(userCache.getHeadPic());
            vo.setNickName(userCache.getNickName());
            vo.setRole(temp.getRole());
            result.add(vo);
        }

        return result;
    }

    @Override
    public GroupInfoVo findGroupInfo(int groupId) {

        Groups group = groupService.getGroupById(groupId);
        if(group == null)
        {
            return null;
        }

        GroupInfoVo result = new GroupInfoVo();
        result.setGroupId(groupId);
        result.setCurrentCount(group.getCurrentCount());
        result.setGroupName(group.getName());
        result.setDescription(group.getDescription());
        result.setGroupImage(group.getImage());
        result.setMaxCount(group.getMaxCount());
        result.setOwnerUid(group.getOwnerUid());
        result.setHxGroupId(group.getHxGroupId());

        return result;
    }

    @Override
    public int sendGroupMessage(int groupId, int userId, String content,String chatImage) {

        try {

            UserCache userCache = userService.getCacheUser(userId);

            Groups group = groupService.getGroupById(groupId);

            //图片消息处理
            String secret = null;
            String imgUrl = null;
            if(null != chatImage && !"".equals(chatImage))
            {
                //TODO 这个地方得改
                chatImage = RsaCoder.decryptByPrivateKey(chatImage);
                String [] message = chatImage.split(";");
                if(message.length == 2)
                {
                    imgUrl = message[0];
                    secret = message[1];
                }
            }

            //消息解密
            String decryptContent = RsaCoder.decryptByPrivateKey(content);

            //TODO 客户端直接对接环信实现信息发送，服务端不做环信接口调用
            //ImMessagePushServer.sendGroupMessage(userCache.getUserName(),decryptContent,group.getHxGroupId(),imgUrl,secret);

            //私钥加密
            String encryptContent = RsaCoder.encryptByPrivateKey(decryptContent);

            return groupChatRecordService.increaseGroupChatRecord(groupId,userId,encryptContent,userCache.getHeadPic(),chatImage);
        } catch (Exception e) {
            logger.error("sendGroupMessage",e);
            return 0;
        }
    }

    @Override
    public List<GroupChatRecordListVo> findGroupChatRecordPage(int groupId, int page, int count) {

        List<GroupChatRecord> list = groupChatRecordService.findGroupChatRecordPage(groupId, page, count);
        if(list == null)
        {
            return new ArrayList<>();
        }

        List<GroupChatRecordListVo> result = new ArrayList<>();
        GroupChatRecordListVo vo;
        for(GroupChatRecord temp:list)
        {
            vo = new GroupChatRecordListVo();
            vo.setUserId(temp.getUserId());
            vo.setNickName(temp.getNickName());
            vo.setChatContent(temp.getChatContent());
            vo.setChatImage(temp.getChatImage());
            vo.setHeadPic(temp.getHeadPic());
            result.add(vo);
        }

        return result;
    }

    @Override
    public int removeGroupMember(int groupId, int userId,int memberId) {
        try {
            int num = groupMemberService.whetherGroupManager(userId,groupId);

            if(num == 0)
            {
                return 2;
            }

            return groupMemberService.removeGroupMember(groupId, memberId);
        } catch (Exception e) {
            logger.error("removeGroupMember",e);
            return 0;
        }
    }

    @Override
    public int modifyPermission(int groupId, int userId, int role,int memberId) {
        try {
            //判断是否是群主
            Groups group = groupService.getGroupById(groupId);
            if(group.getOwnerUid() != userId)
            {
                return 2;
            }
            return groupMemberService.modifyPermission(groupId, memberId, role);
        } catch (Exception e) {
            logger.error("modifyPermission",e);
            return 0;
        }
    }

    @Override
    public int whetherInGroup(int userId, int groupId) {
        try {
            return groupMemberService.whetherInGroup(userId, groupId);
        } catch (Exception e) {
            logger.error("whetherInGroup",e);
            return 0;
        }
    }

    @Override
    public int applyAddGroup(int groupId, int fromUid, String remark) {
        try {
            return groupNoticeService.applyAddGroup(groupId, fromUid, remark);
        } catch (Exception e) {
            logger.error("applyAddGroup",e);
            return 0;
        }
    }

    @Override
    public int inviteAddGroup(int groupId, int fromUid, int receiverUid) {
        try {
            return groupNoticeService.inviteAddGroup(groupId, fromUid, receiverUid);
        } catch (Exception e) {
            logger.error("inviteAddGroup",e);
            return 0;
        }
    }

    @Override
    public List<GroupNoticeListVo> findGroupNoticePageList(int userId, int page, int count) {
        List<GroupNotice> list = groupNoticeService.findGroupNoticePageList(userId, page, count);

        if (list == null) {
            return new ArrayList<>();
        }

        GroupNoticeListVo vo;
        List<GroupNoticeListVo> result = new ArrayList<>();
        Groups group;
        UserCache userCache;
        for (GroupNotice temp:list)
        {
            group = groupService.getGroupById(temp.getGroupId());
            if(group == null)
            {
                continue;
            }
            vo = new GroupNoticeListVo();
            vo.setGroupName(group.getName());
            vo.setNoticeId(temp.getId());
            vo.setNoticeTime(temp.getNoticeTime());
            vo.setRemark(temp.getRemark());
            vo.setStatus(temp.getStatus());
            vo.setType(temp.getType());
            userCache = userService.getCacheUser(temp.getFromUid());
            vo.setNickName(userCache.getNickName());
            vo.setHeadPic(userCache.getHeadPic());
            result.add(vo);
        }

        return result;
    }

    @Override
    public int reviewGroupApply(int noticeId, int flag) {

        try {
            GroupNotice groupNotice = groupNoticeService.getGroupNoticeById(noticeId);

            if (groupNotice == null) {
                return 0;
            }

            if (groupNotice.getType() == GroupNotice.TYPE_SQ)
            {
                if(flag == GroupNotice.APPLY_PASS)
                {
                    groupMemberService.increaseGroupMember(groupNotice.getGroupId(),groupNotice.getFromUid(),GroupMember.ROLE_USER);
                    return groupNoticeService.batchPass(groupNotice.getBatchNumber());
                }
                else
                {
                    return groupNoticeService.batchReject(groupNotice.getBatchNumber());
                }
            }
            else
            {
                if(flag == GroupNotice.APPLY_PASS)
                {
                    groupMemberService.increaseGroupMember(groupNotice.getGroupId(),groupNotice.getReceiverUid(),GroupMember.ROLE_USER);
                    return groupNoticeService.pass(noticeId);
                }
                else
                {
                    return groupNoticeService.reject(noticeId);
                }
            }
        } catch (Exception e) {
            logger.error("reviewGroupApply",e);
            return 0;
        }
    }

    @Override
    public int modifyImage(String image, int groupId) {
        int i = groupService.modifyImage(image, groupId);
        return i;
    }

    @Override
    public int retreat(int userId, int groupId) {
        return groupMemberService.retreat(userId, groupId);
    }
}

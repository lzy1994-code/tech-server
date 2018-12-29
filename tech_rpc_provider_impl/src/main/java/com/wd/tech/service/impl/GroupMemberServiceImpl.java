package com.wd.tech.service.impl;

import com.bw.message.ImGroupServer;
import com.wd.tech.dao.GroupMemberMapper;
import com.wd.tech.rpc.pojo.GroupMember;
import com.wd.tech.rpc.pojo.Groups;
import com.wd.tech.rpc.pojo.User;
import com.wd.tech.service.GroupMemberService;
import com.wd.tech.service.GroupService;
import com.wd.tech.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xyj on 2018/9/4.
 */
@Service("groupMemberService")
public class GroupMemberServiceImpl implements GroupMemberService {

    private Logger logger = LoggerFactory.getLogger("groupMemberService");

    @Resource
    private GroupMemberMapper groupMemberMapper;

    @Resource
    private GroupService groupService;

    @Resource
    private UserService userService;

    @Override
    public int increaseGroupMember(int groupId, int userId, int role) {

        try {
            Groups group = groupService.getGroupById(groupId);
            //判断群组人数是否已满
            if(group.getMaxCount() <= group.getCurrentCount())
            {
                return 2;
            }

            User user = userService.getUserInfoById(userId);

            //添加成员到群组中
            ImGroupServer.groupAddUser(group.getHxGroupId(),user.getUserName());

            //修改群组的人数
            groupService.modifyGroupUserNumber(groupId,1);

            GroupMember groupMember = new GroupMember();
            groupMember.setGroupId(groupId);
            groupMember.setUserId(userId);
            groupMember.setRole(role == 0 ? 1 : role);
            return groupMemberMapper.addMember(groupMember);
        } catch (Exception e) {
            logger.error("increaseGroupMember",e);
            return 0;
        }
    }

    @Override
    public int removeGroupMember(int groupId, int userId) {
        try {
            Groups group = groupService.getGroupById(groupId);
            User user = userService.getUserInfoById(userId);

            ImGroupServer.groupDeleteUser(group.getHxGroupId(),user.getUserName());

            int num = groupMemberMapper.deleteMember(groupId, userId);
            if(num == 0)
            {
                return 2;
            }

            //修改群组的人数
            groupService.modifyGroupUserNumber(groupId,-1);

            return 1;
        } catch (Exception e) {
            logger.error("removeGroupMember",e);
            return 0;
        }
    }

    @Override
    public int modifyPermission(int groupId, int userId, int role) {
        if(role == 0)
        {
            return 0;
        }

        try {
            Groups group = groupService.getGroupById(groupId);
            User user = userService.getUserInfoById(userId);

            if(role == GroupMember.ROLE_USER)
            {
                ImGroupServer.groupDeleteManager(group.getHxGroupId(),user.getUserName());
            }
            else if(role == GroupMember.ROLE_MANAGER)
            {
                ImGroupServer.groupAddManager(group.getHxGroupId(),user.getUserName());
            }
            else
            {
                return 0;
            }
            return groupMemberMapper.modifyPermission(groupId, userId, role);
        } catch (Exception e) {
            logger.error("modifyPermission",e);
            return 0;
        }
    }

    @Override
    public int deleteAllGroupMember(int groupId) {
        return groupMemberMapper.deleteAllGroupMember(groupId);
    }

    @Override
    public int whetherInGroup(int userId, int groupId) {
        return groupMemberMapper.whetherInGroup(userId, groupId);
    }

    @Override
    public List<Integer> findGroupManager(int groupId) {
        return groupMemberMapper.findGroupManager(groupId);
    }

    @Override
    public List<GroupMember> findAllGroupMember(int groupId) {
        return groupMemberMapper.findAllGroupMember(groupId);
    }

    @Override
    public int whetherGroupManager(int userId, int groupId) {
        return groupMemberMapper.whetherGroupManager(userId, groupId);
    }

    @Override
    public int findUserRole(int userId, int groupId) {
        GroupMember userRole = groupMemberMapper.findUserRole(userId, groupId);
        if(userRole != null)
        {
            return userRole.getRole();
        }
        return 1;
    }

    @Override
    public int retreat(int userId, int groupId) {
        //判断是否是群主
        Groups group = groupService.getGroupById(groupId);
        if(group.getOwnerUid() == userId)
        {
            return 3;
        }

        return removeGroupMember(groupId,userId);
    }

}

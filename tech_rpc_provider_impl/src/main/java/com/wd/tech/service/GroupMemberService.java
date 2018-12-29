package com.wd.tech.service;

import com.wd.tech.rpc.pojo.GroupMember;

import java.util.List;

/**
 * Created by xyj on 2018/9/4.
 */
public interface GroupMemberService {

    /**
     *  增加群成员
     * @param groupId
     * @param userId
     * @param role
     * @return
     */
    int increaseGroupMember(int groupId,int userId,int role);

    /**
     *  移出群成员
     * @param groupId
     * @param userId
     * @return
     */
    int removeGroupMember(int groupId,int userId);

    /**
     *  调整群成员角色
     * @param groupId
     * @param userId
     * @param role
     * @return
     */
    int modifyPermission(int groupId,int userId,int role);

    /**
     *  清除所有群内用户
     * @param groupId
     * @return
     */
    int deleteAllGroupMember(int groupId);

    /**
     *  判断用户是否在群里
     * @param userId
     * @param groupId
     * @return
     */
    int whetherInGroup(int userId,int groupId);

    /**
     * 查询群管理
     * @param groupId
     * @return
     */
    List<Integer> findGroupManager(int groupId);

    /**
     *  查询所有群用户
     * @param groupId
     * @return
     */
    List<GroupMember> findAllGroupMember(int groupId);

    /**
     *  是否是群主或群管理员
     * @param userId
     * @param groupId
     * @return
     */
    int whetherGroupManager(int userId,int groupId);

    /**
     * 用户在群里的角色
     * @param userId
     * @param groupId
     * @return
     */
    int findUserRole(int userId,int groupId);

    /**
     *  退群
     * @param userId
     * @param groupId
     * @return
     */
    int retreat(int userId,int groupId);
}

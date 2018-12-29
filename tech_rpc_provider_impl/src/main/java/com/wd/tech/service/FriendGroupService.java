package com.wd.tech.service;

import com.wd.tech.rpc.pojo.FriendGroup;

import java.util.List;

/**
 * Created by xyj on 2018/9/3.
 */
public interface FriendGroupService {

    /**
     *  创建自定义好友分组
     * @param userId
     * @param groupName
     * @return
     */
    int addFriendGroup(int userId,String groupName);

    /**
     *  初始化好友的分组
     * @param userId
     * @return
     */
    int initFriendGroup(int userId);

    /**
     *  根据用户ID查询好友分组
     * @param userId
     * @return
     */
    List<FriendGroup> findFriendGroupList(int userId);

    /**
     * 修改分组名称
     * @param id
     * @param groupName
     * @return
     */
    int modifyGroupName(int id,String groupName);

    /**
     *  增加用户分组人数
     * @param id
     * @return
     */
    int increaseGroupUserNumber(int id);

    /**
     *  减少用户分组人数
     * @param id
     * @return
     */
    int reduceGroupUserNumber(int id);

    /**
     *  删除分组
     * @param id
     * @return
     */
    int deleteGroupById(int id);

    /**
     *  查询用户是否有重复分组名称
     * @param userId
     * @param groupName
     * @return
     */
    int findRepeatGroup(int userId,String groupName);

    /**
     *  查询用户默认我的好友分组ID
     * @param userId
     * @return
     */
    int findDefaultFriendGroup(int userId);

    /**
     *  判断是否是是默认的好友分组和黑名单分组，如果是则返回1不是则返回0
     * @param friendGroupId
     * @return
     */
    int whetherDefaultGroup(int friendGroupId);

}

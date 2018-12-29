package com.wd.tech.service.impl;

import com.wd.tech.dao.FriendGroupMapper;
import com.wd.tech.rpc.pojo.FriendGroup;
import com.wd.tech.service.FriendGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyj on 2018/9/3.
 */
@Service("friendGroupService")
public class FriendGroupServiceImpl implements FriendGroupService {

    @Resource
    private FriendGroupMapper friendGroupMapper;

    @Override
    public int addFriendGroup(int userId, String groupName) {
        FriendGroup friendGroup = new FriendGroup();
        friendGroup.setUserId(userId);
        friendGroup.setName(groupName);
        friendGroup.setBlack(FriendGroup.BLACK_1);
        friendGroup.setCurrentNumber(0);
        friendGroup.setCustomize(FriendGroup.CUSTOMIZE_2);
        friendGroupMapper.addFriendGroup(friendGroup);
        return friendGroup.getId();
    }

    @Override
    public int initFriendGroup(int userId) {

        FriendGroup friendGroup = new FriendGroup();
        friendGroup.setUserId(userId);
        friendGroup.setName(FriendGroup.MY_FRIEND);
        friendGroup.setBlack(FriendGroup.BLACK_1);
        friendGroup.setCurrentNumber(0);
        friendGroup.setCustomize(FriendGroup.CUSTOMIZE_1);

        FriendGroup blackGroup = new FriendGroup();
        blackGroup.setUserId(userId);
        blackGroup.setName(FriendGroup.MY_BLACK);
        blackGroup.setBlack(FriendGroup.BLACK_2);
        blackGroup.setCurrentNumber(0);
        blackGroup.setCustomize(FriendGroup.CUSTOMIZE_1);

        List<FriendGroup> list = new ArrayList<>();
        list.add(friendGroup);
        list.add(blackGroup);

        return friendGroupMapper.batchAddFriendGroup(list);
    }

    @Override
    public List<FriendGroup> findFriendGroupList(int userId) {
        return friendGroupMapper.findFriendGroupList(userId);
    }

    @Override
    public int modifyGroupName(int id, String groupName) {
        return friendGroupMapper.modifyGroupName(id, groupName);
    }

    @Override
    public int increaseGroupUserNumber(int id) {
        return friendGroupMapper.modifyGroupUserNumber(id,1);
    }

    @Override
    public int reduceGroupUserNumber(int id) {
        return friendGroupMapper.modifyGroupUserNumber(id,-1);
    }

    @Override
    public int deleteGroupById(int id) {
        return friendGroupMapper.deleteGroupById(id);
    }

    @Override
    public int findRepeatGroup(int userId, String groupName) {
        return friendGroupMapper.findRepeatGroup(userId,groupName);
    }

    @Override
    public int findDefaultFriendGroup(int userId) {
        return friendGroupMapper.findDefaultFriendGroup(userId);
    }

    @Override
    public int whetherDefaultGroup(int friendGroupId) {
        return friendGroupMapper.whetherDefaultGroup(friendGroupId);
    }

}

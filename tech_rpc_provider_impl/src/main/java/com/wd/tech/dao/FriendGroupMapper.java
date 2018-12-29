package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.FriendGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/9/1.
 */
public interface FriendGroupMapper {

    int addFriendGroup(FriendGroup friendGroup);

    int batchAddFriendGroup(List<FriendGroup> list);

    List<FriendGroup> findFriendGroupList(int userId);

    int modifyGroupName(@Param("id") int id,@Param("groupName") String groupName);

    int modifyGroupUserNumber(@Param("id") int id,@Param("num") int num);

    int deleteGroupById(int id);

    int findRepeatGroup(@Param("userId") int userId,@Param("groupName") String groupName);

    int findDefaultFriendGroup(int userId);

    int whetherDefaultGroup(int friendGroupId);
}

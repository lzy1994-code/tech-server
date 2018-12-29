package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.GroupMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/9/4.
 */
public interface GroupMemberMapper {

    int addMember(GroupMember groupMember);

    int deleteMember(@Param("groupId") int groupId,@Param("userId") int userId);

    int modifyPermission(@Param("groupId")int groupId,@Param("userId")int userId,@Param("role")int role);

    int deleteAllGroupMember(int groupId);

    int whetherInGroup(@Param("userId") int userId,@Param("groupId") int groupId);

    List<Integer> findGroupManager(int groupId);

    List<GroupMember> findAllGroupMember(int groupId);

    int whetherGroupManager(@Param("userId") int userId,@Param("groupId") int groupId);

    GroupMember findUserRole(@Param("userId") int userId,@Param("groupId") int groupId);
}

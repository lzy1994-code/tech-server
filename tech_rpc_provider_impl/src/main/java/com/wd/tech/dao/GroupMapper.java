package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.Groups;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/9/4.
 */
public interface GroupMapper {

    int addGroup(Groups groups);

    int modifyGroupName(@Param("id") int id,@Param("groupName") String groupName);

    int modifyGroupDescription(@Param("id")int id,@Param("description")String description);

    int modifyGroupUserNumber(@Param("id")int id,@Param("num")int num);

    int deleteGroup(int id);

    List<Groups> findGroupsByUserId(int userId);

    List<Groups> findUserJoinedGroup(int userId);

    int checkGroupName(@Param("groupName")String groupName,@Param("userId")int userId);

    Groups getGroupById(int id);

    int getGroupCurrentCount(int id);

    int modifyImage(@Param("image") String image,@Param("groupId") int groupId);

}

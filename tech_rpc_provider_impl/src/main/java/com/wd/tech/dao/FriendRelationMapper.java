package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.FriendRelation;
import com.wd.tech.rpc.vo.FriendListVo;
import com.wd.tech.rpc.vo.FriendSearchVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/9/4.
 */
public interface FriendRelationMapper {

    int addFriendRelation(FriendRelation friendRelation);

    List<FriendRelation> findUserFriendRelationList(int userId);

    int deleteFriendRelation(@Param("userId") int userId,@Param("friendUid") int friendUid);

    int modifyFriendRemark(@Param("userId") int userId,@Param("friendUid") int friendUid,@Param("remarkName") String remarkName);

    int modifyFriendGroup(@Param("userId")int userId,@Param("friendUid")int friendUid,@Param("groupId")int groupId);

    int checkMyFriend(@Param("userId")int userId,@Param("friendUid")int friendUid);

    int findFriendGroupId(@Param("userId")int userId,@Param("friendUid")int friendUid);

    int batchTransferFriendGroup(@Param("userId") int userId,@Param("oldGroupId")int oldGroupId,@Param("newGroupId")int newGroupId);

    List<FriendListVo> findFriendListByGroupId(@Param("userId") int userId,@Param("groupId") int groupId);

    List<FriendSearchVo> searchFriend(@Param("userId") int userId,@Param("searchName") String searchName);
}

package com.wd.tech.service;

import com.wd.tech.rpc.pojo.FriendRelation;
import com.wd.tech.rpc.vo.FriendListVo;
import com.wd.tech.rpc.vo.FriendSearchVo;

import java.util.List;

/**
 * Created by xyj on 2018/9/4.
 */
public interface FriendRelationService {

    /**
     *  添加好友
     * @param userId
     * @param friendUid
     * @param groupId
     * @param remarkName
     * @return
     */
    int addFriend(int userId,int friendUid,int groupId,String remarkName);

    /**
     *  查询用户好友列表
     * @param userId
     * @return
     */
    List<FriendRelation> findUserFriendRelationList(int userId);

    /**
     *  删除好友
     * @param userId
     * @param friendUid
     * @return
     */
    int deleteFriendRelation(int userId,int friendUid);

    /**
     *  修改好友备注
     * @param userId
     * @param friendUid
     * @param remarkName
     * @return
     */
    int modifyFriendRemark(int userId,int friendUid,String remarkName);

    /**
     *  修改好友分组
     * @param userId
     * @param friendUid
     * @param groupId
     * @return
     */
    int modifyFriendGroup(int userId,int friendUid,int groupId);

    /**
     *  检测是否为我的好友
     * @param userId
     * @param friendUid
     * @return
     */
    int checkMyFriend(int userId,int friendUid);

    /**
     *  查询好友所在分组ID
     * @param userId
     * @param friendUid
     * @return
     */
    int findFriendGroupId(int userId,int friendUid);

    /**
     *  批量转移好友到新的分组
     * @param userId
     * @param oldGroupId
     * @param newGroupId
     * @return
     */
    int batchTransferFriendGroup(int userId,int oldGroupId,int newGroupId);

    /**
     *  查询好友列表
     * @param userId
     * @param groupId
     * @return
     */
    List<FriendListVo> findFriendListByGroupId(int userId, int groupId);

    /**
     *  模糊搜索好友,根据用户昵称、备注名称搜索
     * @param userId
     * @param searchName
     * @return
     */
    List<FriendSearchVo> searchFriend(int userId,String searchName);

}

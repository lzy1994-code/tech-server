package com.wd.tech.rpc.api;

import com.wd.tech.rpc.vo.*;

import java.util.List;

/**
 * Created by xyj on 2018/9/5.
 */
public interface ChatRpcService {

    /**
     *  添加好友
     * @param userId
     * @param friendUid
     * @param remark
     * @return
     */
    int addFriend(int userId, int friendUid, String remark);

    /**
     *  删除好友
     * @param userId
     * @param friendUid
     * @return
     */
    int deleteFriendRelation(int userId, int friendUid);

    /**
     *  修改好友备注
     * @param userId
     * @param friendUid
     * @param remarkName
     * @return
     */
    int modifyFriendRemark(int userId, int friendUid, String remarkName);

    /**
     *  检测是否为我的好友
     * @param userId
     * @param friendUid
     * @return
     */
    int checkMyFriend(int userId, int friendUid);

    /**
     *  创建自定义好友分组
     * @param userId
     * @param groupName
     * @return
     */
    int addFriendGroup(int userId, String groupName);

    /**
     *  查询用户所有分组
     * @param userId
     * @return
     */
    List<FriendGroupListVo> findFriendGroupList(int userId);

    /**
     * 修改好友分组名称
     * @param groupId
     * @param groupName
     * @return
     */
    int modifyGroupName(int groupId, String groupName);

    /**
     *  转移好友到其他分组
     * @param userId
     * @param friendUid
     * @param newGroupId
     * @return
     */
    int transferFriendGroup(int userId, int friendUid, int newGroupId);

    /**
     *  删除用户好友分组
     * @param userId
     * @param groupId
     * @return
     */
    int deleteFriendGroup(int userId, int groupId);

    /**
     *  查询分组下的好友列表信息
     * @param userId
     * @param groupId
     * @return
     */
    List<FriendListVo> findFriendListByGroupId(int userId, int groupId);

    /**
     * 查询用户的好友通知记录
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<FriendNoticeListVo> findFriendNoticePageList(int userId, int page, int count);

    /**
     * 审核好友申请
     * @param noticeId
     * @param flag
     * @return
     */
    int reviewFriendApply(int noticeId, int flag);

    /**
     *  发送消息
     * @param sendUid
     * @param receiveUid
     * @param content
     * @param chatImage
     * @return
     */
    int sendMessage(int sendUid, int receiveUid, String content, String chatImage);

    /**
     *  查询好友聊天记录
     * @param userId
     * @param friendUid
     * @param page
     * @param count
     * @return
     */
    List<ChatRecordListVo> findChatRecordPageList(int userId, int friendUid, int page, int count);

    /**
     *  查询好友对话记录
     * @param userId
     * @param friendUid
     * @param page
     * @param count
     * @return
     */
    List<DialogueRecordListVo> findDialogueRecordPageList(int userId, int friendUid, int page, int count);

    /**
     *  删除好友聊天记录
     * @param userId
     * @param friendUid
     * @return
     */
    int deleteChatRecord(int userId, int friendUid);

    /**
     *  模糊搜索好友,根据用户昵称、备注名称搜索
     * @param userId
     * @param searchName
     * @return
     */
    List<FriendSearchVo> searchFriend(int userId,String searchName);

}

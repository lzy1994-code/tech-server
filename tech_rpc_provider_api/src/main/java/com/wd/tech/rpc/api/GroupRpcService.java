package com.wd.tech.rpc.api;

import com.wd.tech.rpc.vo.*;

import java.util.List;

/**
 * Created by xyj on 2018/9/6.
 */
public interface GroupRpcService {

    /**
     *  创建群组
     * @param name
     * @param description
     * @param userId
     * @return
     */
    int createGroup(String name, String description, int userId);

    /**
     *  修改群组名
     * @param groupId
     * @param groupName
     * @return
     */
    int modifyGroupName(int groupId, String groupName);

    /**
     *  修改群备注
     * @param groupId
     * @param description
     * @return
     */
    int modifyGroupDescription(int groupId, String description);

    /**
     * 解散群组
     * @param groupId
     * @param userId
     * @return
     */
    int disbandGroup(int groupId, int userId);

    /**
     *  查询我创建的群组
     * @param userId
     * @return
     */
    List<GroupListVo> findGroupsByUserId(int userId);

    /**
     *  查询我所有加入的群组
     * @param userId
     * @return
     */
    List<GroupListVo> findUserJoinedGroup(int userId);

    /**
     *  查询群组内所有用户信息
     * @param groupId
     * @return
     */
    List<GroupMemberListVo> findGroupMemberList(int groupId);

    /**
     *  查询群组详细信息
     * @param groupId
     * @return
     */
    GroupInfoVo findGroupInfo(int groupId);

    /**
     *  发送群信息
     * @param groupId
     * @param userId
     * @param content
     * @param chatImage
     * @return
     */
    int sendGroupMessage(int groupId, int userId, String content,String chatImage);

    /**
     *  查询群聊天内容
     * @param groupId
     * @param page
     * @param count
     * @return
     */
    List<GroupChatRecordListVo> findGroupChatRecordPage(int groupId, int page, int count);

    /**
     *  移出群成员
     * @param groupId
     * @param userId
     * @param memberId
     * @return
     */
    int removeGroupMember(int groupId, int userId,int memberId);

    /**
     *  调整群成员角色
     * @param groupId
     * @param userId
     * @param role
     * @param memberId
     * @return
     */
    int modifyPermission(int groupId, int userId, int role,int memberId);

    /**
     *  判断用户是否已在群内
     * @param userId
     * @param groupId
     * @return
     */
    int whetherInGroup(int userId, int groupId);

    /**
     *  申请进群
     * @param groupId
     * @param fromUid
     * @param remark
     * @return
     */
    int applyAddGroup(int groupId, int fromUid, String remark);

    /**
     *  邀请加群
     * @param groupId
     * @param fromUid
     * @param receiverUid
     * @return
     */
    int inviteAddGroup(int groupId, int fromUid, int receiverUid);

    /**
     *  查询群通知记录
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<GroupNoticeListVo> findGroupNoticePageList(int userId, int page, int count);

    /**
     * 审核群申请
     * @param noticeId
     * @param flag
     * @return
     */
    int reviewGroupApply(int noticeId, int flag);

    /**
     * 修改群头像
     * @param image
     * @param groupId
     * @return
     */
    int modifyImage(String image,int groupId);

    /**
     *  退群
     * @param userId
     * @param groupId
     * @return
     */
    int retreat(int userId,int groupId);

}

package com.wd.tech.rpc.impl;

import com.wd.tech.rpc.api.ChatRpcService;
import com.wd.tech.rpc.pojo.ChatRecord;
import com.wd.tech.rpc.pojo.FriendGroup;
import com.wd.tech.rpc.pojo.FriendNotice;
import com.wd.tech.rpc.pojo.User;
import com.wd.tech.rpc.vo.*;
import com.wd.tech.service.*;
import com.wd.tech.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyj on 2018/9/6.
 */
@Service("chatRpcService")
public class ChatRpcServiceImpl implements ChatRpcService {

    private Logger logger = LoggerFactory.getLogger("chatRpcService");

    @Resource
    private FriendNoticeService friendNoticeService;

    @Resource
    private FriendRelationService friendRelationService;

    @Resource
    private FriendGroupService friendGroupService;

    @Resource
    private UserService userService;

    @Resource
    private SysNoticeService sysNoticeService;

    @Resource
    private ChatRecordService chatRecordService;

    @Resource
    private UserVipService userVipService;

    @Override
    public int addFriend(int userId, int friendUid,String remark) {

        try {
            if(userId == friendUid)
            {
                return 4;
            }

            //判断该用户是否存在
            User userInfoById = userService.getUserInfoById(friendUid);
            if (userInfoById == null){
                return 3;
            }
            //判断是否已是好友
            if(checkMyFriend(userId, friendUid) > 0)
            {
                return 2;
            }

            return friendNoticeService.increaseFriendNotice(userId,friendUid,remark);
        } catch (Exception e) {
            logger.error("addFriend",e);
            return 0;
        }
    }

    @Override
    public int deleteFriendRelation(int userId, int friendUid) {

        try {
            //查询好友所在分组ID
            int groupId = friendRelationService.findFriendGroupId(userId, friendUid);

            //好友所在分组人数调整
            friendGroupService.reduceGroupUserNumber(groupId);

            //删除好友关系
            friendRelationService.deleteFriendRelation(userId, friendUid);

            return 1;
        } catch (Exception e) {
            logger.error("deleteFriendRelation",e);
            return 0;
        }
    }

    @Override
    public int modifyFriendRemark(int userId, int friendUid, String remarkName) {
        try {
            return friendRelationService.modifyFriendRemark(userId, friendUid, remarkName);
        } catch (Exception e) {
            logger.error("modifyFriendRemark",e);
            return 0;
        }
    }

    @Override
    public int checkMyFriend(int userId, int friendUid) {
        try {
            return friendRelationService.checkMyFriend(userId, friendUid);
        } catch (Exception e) {
            logger.error("checkMyFriend",e);
            return 0;
        }
    }

    @Override
    public int addFriendGroup(int userId, String groupName) {

        try {
            //查询是否有重复的分组名称
            if(friendGroupService.findRepeatGroup(userId, groupName) > 0)
            {
                return 2;
            }
            return friendGroupService.addFriendGroup(userId, groupName);
        } catch (Exception e) {
            logger.error("checkMyFriend",e);
            return 0;
        }

    }

    @Override
    public List<FriendGroupListVo> findFriendGroupList(int userId) {

        List<FriendGroup> friendGroupList = friendGroupService.findFriendGroupList(userId);
        if(friendGroupList == null)
        {
            return new ArrayList<>();
        }

        FriendGroupListVo temp;
        List<FriendGroupListVo> result = new ArrayList<>();
        for(FriendGroup friendGroup:friendGroupList)
        {
            temp = new FriendGroupListVo();
            temp.setGroupId(friendGroup.getId());
            temp.setGroupName(friendGroup.getName());
            temp.setCurrentNumber(friendGroup.getCurrentNumber());
            temp.setCustomize(friendGroup.getCustomize());
            temp.setBlack(friendGroup.getBlack());
            result.add(temp);
        }
        return result;
    }

    @Override
    public int modifyGroupName(int groupId, String groupName) {
        try {
            return friendGroupService.modifyGroupName(groupId, groupName);
        } catch (Exception e) {
            logger.error("modifyGroupName",e);
            return 0;
        }
    }

    @Override
    public int transferFriendGroup(int userId, int friendUid, int newGroupId) {
        try {
            int friendGroupId = friendRelationService.findFriendGroupId(userId, friendUid);
            //原分组人数减少
            friendGroupService.reduceGroupUserNumber(friendGroupId);

            //调整好友分组
            friendRelationService.modifyFriendGroup(userId, friendUid, newGroupId);

            //新分组人数增加
            friendGroupService.increaseGroupUserNumber(newGroupId);

            return 1;
        } catch (Exception e) {
            logger.error("transferFriendGroup",e);
            return 0;
        }

    }

    @Override
    public int deleteFriendGroup(int userId, int groupId) {

        try {
            //判断是否为系统默认分组,如果是则不能删除
            int num = friendGroupService.whetherDefaultGroup(groupId);
            if(num == 1)
            {
                return 2;
            }

            //查询用户默认我的好友分组ID
            int defaultFriendGroup = friendGroupService.findDefaultFriendGroup(userId);

            //将要删除分组内的好友全部转移到默认分组我的好友中
            friendRelationService.batchTransferFriendGroup(userId,groupId,defaultFriendGroup);

            //删除好友分组
            friendGroupService.deleteGroupById(groupId);

            return 1;
        } catch (Exception e) {
            logger.error("deleteFriendGroup",e);
            return 0;
        }
    }

    @Override
    public List<FriendListVo> findFriendListByGroupId(int userId, int groupId) {
        List<FriendListVo> list = friendRelationService.findFriendListByGroupId(userId, groupId);
        if(list == null)
        {
            return new ArrayList<>();
        }

        //处理好友是否是VIP的状态
        for(FriendListVo vo:list)
        {
            vo.setVipFlag(userVipService.whetherVipUser(vo.getFriendUid()));
        }

        return list;
    }

    @Override
    public List<FriendNoticeListVo> findFriendNoticePageList(int userId, int page, int count) {
        List<FriendNotice> friendNoticePageList = friendNoticeService.findFriendNoticePageList(userId, page, count);
        if(friendNoticePageList == null)
        {
            return new ArrayList<>();
        }

        FriendNoticeListVo vo;
        List<FriendNoticeListVo> result = new ArrayList<>();
        User user;
        for(FriendNotice notice:friendNoticePageList)
        {
            vo = new FriendNoticeListVo();
            vo.setNoticeId(notice.getId());
            vo.setFromUid(notice.getFromUid());
            vo.setReceiveUid(notice.getReceiveUid());
            vo.setRemark(notice.getRemark());
            vo.setNoticeTime(notice.getNoticeTime());
            vo.setStatus(notice.getStatus());
            user = userService.getUserInfoById(notice.getFromUid());
            if(user == null)
            {
                continue;
            }
            vo.setFromHeadPic(user.getHeadPic());
            vo.setFromNickName(user.getNickName());
            result.add(vo);
        }
        return result;
    }

    @Override
    public int reviewFriendApply(int noticeId, int flag) {

        try {
            //查询好友申请详情
            FriendNotice friendNotice = friendNoticeService.findFriendNoticeById(noticeId);
            if(friendNotice == null)
            {
                return 3;
            }

            if(friendNotice.getStatus() != 1)
            {
                return 4;
            }

            //查询好友邀请接收人的信息
            User user = userService.getUserInfoById(friendNotice.getFromUid());
            //查询申请加好友的信息
            User friendUser = userService.getUserInfoById(friendNotice.getReceiveUid());
            String content = null;
            if(flag == FriendNotice.STATUS_TG)
            {
                //查询用户默认好友分组ID
                int myDefaultFriendGroup = friendGroupService.findDefaultFriendGroup(friendNotice.getReceiveUid());
                //查询好友的默认好友分组ID
                int defaultFriendGroup = friendGroupService.findDefaultFriendGroup(friendNotice.getFromUid());
                String remarkName = friendNotice.getRemark();
                if(remarkName == null || "".equals(remarkName))
                {
                    remarkName = user.getNickName();
                }
                //添加好友,双向处理
                friendRelationService.addFriend(friendNotice.getReceiveUid(),friendNotice.getFromUid(),myDefaultFriendGroup,remarkName);
                friendRelationService.addFriend(friendNotice.getFromUid(),friendNotice.getReceiveUid(),defaultFriendGroup,user.getNickName());

                //修改通知状态
                friendNoticeService.pass(noticeId);

                //修改好友分组人数
                friendGroupService.increaseGroupUserNumber(myDefaultFriendGroup);
                friendGroupService.increaseGroupUserNumber(defaultFriendGroup);

                //系统通知申请人添加好友成功的信息
                content = String.format(Constants.SYS_NOTICE_ADD_FRIEND_PASS,friendUser.getNickName());
            }
            else if(flag == FriendNotice.STATUS_JJ)
            {
                //系统通知申请人被拒绝的信息
                content = String.format(Constants.SYS_NOTICE_ADD_FRIEND_REFUSE,friendUser.getNickName());
                //修改通知状态
                friendNoticeService.reject(noticeId);
            }
            else
            {
                return 2;
            }

            sysNoticeService.addSysNotice(friendNotice.getFromUid(),content);

            return 1;
        } catch (Exception e) {
            logger.error("reviewFriendApply",e);
            return 0;
        }
    }

    @Override
    public int sendMessage(int sendUid, int receiveUid, String content, String chatImage) {
        try {
            return chatRecordService.saveChatRecord(sendUid,receiveUid,content,chatImage);
        } catch (Exception e) {
            logger.error("sendMessage",e);
            return 0;
        }
    }

    @Override
    public List<ChatRecordListVo> findChatRecordPageList(int userId, int friendUid, int page, int count) {

        List<ChatRecord> chatRecordList = chatRecordService.findChatRecordPageList(userId, friendUid, page, count);
        if(chatRecordList == null)
        {
            return new ArrayList<>();
        }

        ChatRecordListVo vo;
        List<ChatRecordListVo> result = new ArrayList<>();
        User user = userService.getUserInfoById(userId);
        User friend = userService.getUserInfoById(friendUid);
        for(ChatRecord temp:chatRecordList)
        {
            vo = new ChatRecordListVo();
            if(temp.getDirection() == ChatRecord.DIRECTION_SEND)
            {
                vo.setNickName(user.getNickName());
            }
            else
            {
                vo.setNickName(friend.getNickName());
            }
            vo.setContent(temp.getChatContent());
            vo.setChatTime(temp.getChatTime());
            //图片地址和密码用分号间隔开，客户端需要拆分
            vo.setPicUrl(temp.getChatImage());
            result.add(vo);
        }

        return result;
    }

    @Override
    public List<DialogueRecordListVo> findDialogueRecordPageList(int userId, int friendUid, int page, int count) {

        List<ChatRecord> chatRecordList = chatRecordService.findChatRecordPageList(userId, friendUid, page, count);
        if(chatRecordList == null)
        {
            return new ArrayList<>();
        }

        DialogueRecordListVo vo;
        List<DialogueRecordListVo> result = new ArrayList<>();
        User user = userService.getUserInfoById(userId);
        User friend = userService.getUserInfoById(friendUid);
        for(ChatRecord temp:chatRecordList)
        {
            vo = new DialogueRecordListVo();
            if(temp.getDirection() == ChatRecord.DIRECTION_SEND)
            {
                vo.setUserId(userId);
                vo.setHeadPic(user.getHeadPic());
            }
            else
            {
                vo.setUserId(friendUid);
                vo.setHeadPic(friend.getHeadPic());
            }
            vo.setContent(temp.getChatContent());
            vo.setDirection(temp.getDirection());
            vo.setChatTime(temp.getChatTime());
            vo.setPicUrl(temp.getChatImage());
            result.add(vo);
        }

        return result;
    }

    @Override
    public int deleteChatRecord(int userId, int friendUid) {
        try {
            return chatRecordService.deleteChatRecord(userId,friendUid);
        } catch (Exception e) {
            logger.error("deleteChatRecord",e);
            return 0;
        }
    }

    @Override
    public List<FriendSearchVo> searchFriend(int userId, String searchName) {
        try {
            return friendRelationService.searchFriend(userId,searchName);
        } catch (Exception e) {
            logger.error("deleteChatRecord",e);
            return new ArrayList<>();
        }
    }
}

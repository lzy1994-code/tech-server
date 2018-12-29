package com.wd.tech.service.impl;

import com.wd.tech.dao.FriendRelationMapper;
import com.wd.tech.rpc.pojo.FriendRelation;
import com.wd.tech.rpc.vo.FriendListVo;
import com.wd.tech.rpc.vo.FriendSearchVo;
import com.wd.tech.service.FriendRelationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyj on 2018/9/4.
 */
@Service("friendRelationService")
public class FriendRelationServiceImpl implements FriendRelationService {

    private Logger logger = LoggerFactory.getLogger("friendRelationService");

    @Resource
    private FriendRelationMapper friendRelationMapper;

    @Override
    public int addFriend(int userId, int friendUid, int groupId, String remarkName) {

        try {
            if(checkMyFriend(userId, friendUid) > 0)
            {
                return 2;
            }

            FriendRelation friendRelation = new FriendRelation();
            friendRelation.setFriendUid(friendUid);
            friendRelation.setFriendGroupId(groupId);
            friendRelation.setUserId(userId);
            friendRelation.setRemarkName(remarkName);

            return friendRelationMapper.addFriendRelation(friendRelation);
        } catch (Exception e) {
            logger.error("addFriend",e);
            return 0;
        }
    }

    @Override
    public List<FriendRelation> findUserFriendRelationList(int userId) {
        return friendRelationMapper.findUserFriendRelationList(userId);
    }

    @Override
    public int deleteFriendRelation(int userId, int friendUid) {
        try {
            //双向删除好友关系
            friendRelationMapper.deleteFriendRelation(userId, friendUid);
            friendRelationMapper.deleteFriendRelation(friendUid, userId);
            return 1;
        } catch (Exception e) {
            logger.error("deleteFriendRelation",e);
            return 0;
        }
    }

    @Override
    public int modifyFriendRemark(int userId, int friendUid, String remarkName) {
        try {
            return friendRelationMapper.modifyFriendRemark(userId, friendUid,remarkName);
        } catch (Exception e) {
            logger.error("modifyFriendRemark",e);
            return 0;
        }
    }

    @Override
    public int modifyFriendGroup(int userId, int friendUid, int groupId) {
        try {
            return friendRelationMapper.modifyFriendGroup(userId, friendUid,groupId);
        } catch (Exception e) {
            logger.error("modifyFriendGroup",e);
            return 0;
        }
    }

    @Override
    public int checkMyFriend(int userId, int friendUid) {
        try {
            return friendRelationMapper.checkMyFriend(userId, friendUid);
        } catch (Exception e) {
            logger.error("checkMyFriend",e);
            return 0;
        }
    }

    @Override
    public int findFriendGroupId(int userId, int friendUid) {
        try {
            return friendRelationMapper.findFriendGroupId(userId, friendUid);
        } catch (Exception e) {
            logger.error("findFriendGroupId",e);
            return 0;
        }
    }

    @Override
    public int batchTransferFriendGroup(int userId, int oldGroupId, int newGroupId) {
        try {
            return friendRelationMapper.batchTransferFriendGroup(userId, oldGroupId, newGroupId);
        } catch (Exception e) {
            logger.error("batchTransferFriendGroup",e);
            return 0;
        }
    }

    @Override
    public List<FriendListVo> findFriendListByGroupId(int userId, int groupId) {
        return friendRelationMapper.findFriendListByGroupId(userId, groupId);
    }

    @Override
    public List<FriendSearchVo> searchFriend(int userId, String searchName) {
        List<FriendSearchVo> friendSearchVos = friendRelationMapper.searchFriend(userId, searchName);
        if(friendSearchVos == null)
        {
            return new ArrayList<>();
        }
        return friendSearchVos;
    }

}

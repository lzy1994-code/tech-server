package com.wd.tech.rpc.impl;

import com.wd.tech.rpc.api.CommunityRpcService;
import com.wd.tech.rpc.pojo.Community;
import com.wd.tech.rpc.pojo.CommunityComment;
import com.wd.tech.rpc.pojo.User;
import com.wd.tech.rpc.pojo.UserCache;
import com.wd.tech.rpc.vo.*;
import com.wd.tech.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 社区Rpc实现
 * @author: Lzy
 * @create: 2018-09-11 14:33
 **/
@Service("communityRpcService")
public class CommunityRpcServiceImpl implements CommunityRpcService {

    @Resource
    private CommunityService communityService;
    @Resource
    private CommunityGreatService communityGreatService;
    @Resource
    private CommunityCommentService communityCommentService;
    @Resource
    private UserService userService;
    @Resource
    private FriendRelationService friendRelationService;
    @Resource
    private FocusUserService focusUserService;
    @Override
    public List<CommunityVo> findCommunityList(int userId, int page, int count) {

        List<CommunityVo> communityList = communityService.findCommunityList(userId, page, count);
        if(communityList.isEmpty()){
            return new ArrayList<>();
        }
        return communityList;
    }

    @Override
    public int releasePost(int userId, String content, String file) {
        return communityService.releasePost(userId,content,file);
    }

    @Override
    public int deletePost(int userId, List<Integer> ids) {
        int i = communityService.deletePost(userId, ids);
        return i;
    }


    @Override
    public boolean addCommunityGreat(int userId, int communityId) {
        return communityGreatService.addCommunityGreat(userId,communityId);
    }

    @Override
    public boolean cancelCommunityGreat(int userId, int communityId) {
        return communityGreatService.cancelCommunityGreat(userId,communityId);
    }

    @Override
    public List<String> findCommunityCommentList(int communityId, int page, int count) {
        List<String> communityCommentList = communityCommentService.findCommunityCommentList(communityId, page, count);
       if (communityCommentList.isEmpty()){
           return new ArrayList<>();
       }
        return communityCommentList;
    }

    @Override
    public int addCommunityComment(int userId, int communityId, String content) {
        boolean b = communityCommentService.addCommunityComment(userId,communityId,content);
        if (b){
            return 1;
        }
        return 0;
    }

    @Override
    public List<UserPostVo> findMyPostById(int userId, int page, int count) {
        List<UserPostVo> userPostByIdList = communityService.findMyPostById(userId, page, count);
        if (userPostByIdList.isEmpty()){
            return new ArrayList<>();
        }
        return userPostByIdList;
    }

    @Override
    public List<CommunityUserListVo> findUserPostById(int userId,int fromUid, int page, int count) {
        List<CommunityUserListVo> communityUserListVos = new ArrayList<>();
        CommunityUserListVo communityUserListVo = new CommunityUserListVo();
      //用户信息
        CommunityUserVo communityUserVo = new CommunityUserVo();
        User userInfoById = userService.getUserInfoById(fromUid);
        communityUserVo.setUserId(fromUid);
        communityUserVo.setNickName(userInfoById.getNickName());
        communityUserVo.setHeadPic(userInfoById.getHeadPic());
        communityUserVo.setSignature(userInfoById.getSignature());
        if (userId == fromUid){
            communityUserVo.setPower(1);
        }else {
            communityUserVo.setPower(2);
        }
        //是否为好友
        int i = friendRelationService.checkMyFriend(userId, fromUid);
        if (i == 1){
            communityUserVo.setWhetherMyFriend(1);
        }else {
            communityUserVo.setWhetherMyFriend(2);
        }
         //是否关注
        int j = focusUserService.whetherFollowUser(userId, fromUid);
        communityUserVo.setWhetherFollow(j);
        communityUserListVo.setCommunityUserVo(communityUserVo);
        //帖子信息
        List<CommunityUserPostVo> userPostByIdList = communityService.findUserPostById(userId,fromUid, page, count);
        communityUserListVo.setCommunityUserPostVoList(userPostByIdList);
        communityUserListVos.add(communityUserListVo);
        return communityUserListVos;
    }

    @Override
    public List<CommunityUserCommentVo> findCommunityUserCommentList(int communityId, int page, int count) {
        List<CommunityUserCommentVo> communityUserCommentList = communityCommentService.findCommunityUserCommentList(communityId, page, count);
        if (communityUserCommentList.isEmpty()){
            return  new ArrayList<>();
        }
        return communityUserCommentList;
    }

}

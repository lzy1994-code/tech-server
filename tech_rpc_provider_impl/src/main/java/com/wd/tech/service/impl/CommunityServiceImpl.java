package com.wd.tech.service.impl;

import com.wd.tech.dao.*;
import com.wd.tech.rpc.pojo.Community;
import com.wd.tech.rpc.vo.*;
import com.wd.tech.service.CommunityGreatService;
import com.wd.tech.service.CommunityService;
import com.wd.tech.service.FocusUserService;
import com.wd.tech.service.UserVipService;
import com.wd.tech.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 社区实现类
 * @author: Lzy
 * @create: 2018-09-05 15:42
 **/
@Service("communityService")
public class CommunityServiceImpl implements CommunityService {

    @Resource
    private CommunityMapper communityMapper;

    @Resource
    private CommunityCommentMapper communityCommentMapper;

    @Resource
    private FocusUserService focusUserService;

    @Resource
    private CommunityGreatService communityGreatService;

    @Resource
    private UserVipService userVipService;

    @Resource
    private CommunityCountMapper communityCountMapper;


    @Override
    public List<CommunityVo> findCommunityList(int userId, int page, int count) {
        List<CommunityVo> communityList = communityMapper.findCommunityList(CommonUtil.getPageIndex(page, count), count);
        for (CommunityVo communityVo:communityList) {
                communityVo.setWhetherFollow(focusUserService.whetherFollowUser(userId,communityVo.getUserId()));
                communityVo.setWhetherGreat(communityGreatService.whetherCommunityGreat(userId, communityVo.getId()));
                communityVo.setWhetherVip( userVipService.whetherVipUser(communityVo.getUserId()));
                //新增附带三条最新评论
            List<CommunityCommentVo> communityCommentList = communityCommentMapper.findCommunityCommentList(communityVo.getId(), 0, 3);
            communityVo.setCommunityCommentVoList(communityCommentList);
        }
        return communityList;
    }

    @Override
    public int releasePost(int userId,String content,String file) {
        Community community = new Community();
        community.setContent(content);
        community.setUserId(userId);
        community.setFile(file);
        int i = communityMapper.releasePost(community);
        if (i!=0){
            communityCountMapper.addCommunityCount(community.getId());
        }
        return i;
    }

    @Override
    public int deletePost(int userId, List<Integer> ids) {
        for (int id:ids) {
            int i = whetherMyPost(userId, id);
            if (i == 1){
                boolean b = communityMapper.deletePost(ids);
                if (b){
                    return 1;
                }
            }else {
                return 2;
            }
        }
        return 0;
    }


    @Override
    public int whetherMyPost(int userId, int id) {
        int i = communityMapper.whetherMyPost(userId, id);
        if (i==1){
            return 1;
        }
        return 2;
    }

    @Override
    public List<UserPostVo> findMyPostById(int userId, int page, int count) {
        return communityMapper.findMyPostById(userId,CommonUtil.getPageIndex(page, count),count);
    }

    @Override
    public List<CommunityUserPostVo> findUserPostById(int userId,int fromUid, int page, int count) {
        List<CommunityUserPostVo> userPostById = communityMapper.findUserPostById(fromUid, CommonUtil.getPageIndex(page, count), count);
        for (CommunityUserPostVo communityUserPostVo: userPostById) {
            communityUserPostVo.setWhetherGreat(communityGreatService.whetherCommunityGreat(userId,communityUserPostVo.getId()));
        }
        return userPostById;
    }


}

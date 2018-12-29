package com.wd.tech.service.impl;

import com.wd.tech.dao.CommunityCommentMapper;
import com.wd.tech.dao.CommunityCountMapper;
import com.wd.tech.rpc.pojo.CommunityComment;
import com.wd.tech.rpc.pojo.User;
import com.wd.tech.rpc.vo.CommunityCommentVo;
import com.wd.tech.rpc.vo.CommunityUserCommentVo;
import com.wd.tech.service.CommunityCommentService;
import com.wd.tech.service.UserService;
import com.wd.tech.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 社区评论实现类
 * @author: Lzy
 * @create: 2018-09-05 16:46
 **/
@Service("communityCommentService")
public class CommunityCommentServiceImpl implements CommunityCommentService {

    @Resource
    private CommunityCommentMapper communityCommentMapper;

    @Resource
    private CommunityCountMapper communityCountMapper;

    @Resource
    private UserService userService;

    @Override
    public List<String>  findCommunityCommentList(int communityId, int page, int count) {
        String str = "";
        List<String> list = new ArrayList<>();
        List<CommunityCommentVo> communityCommentList = communityCommentMapper.findCommunityCommentList(communityId, CommonUtil.getPageIndex(page, count), count);
        for (CommunityCommentVo communityCommentVo:communityCommentList) {
            int userId = communityCommentVo.getUserId();
            String nickName = communityCommentVo.getNickName();
            String content = communityCommentVo.getContent();
            str = "<comment userId='" + userId +
                    "' nickName='" + nickName +
                    "' content='" + content + "'></comment>";
            list.add(str);
        }
        return list;
    }

    @Override
    public boolean addCommunityComment(int userId, int communityId, String content) {
        User userInfo = userService.getUserInfoById(userId);
        String nickName = userInfo.getNickName();
        CommunityComment communityComment = new CommunityComment();
        communityComment.setNickName(nickName);
        communityComment.setUserId(userId);
        communityComment.setCommunityId(communityId);
        communityComment.setContent(content);
        boolean b = communityCommentMapper.addCommunityComment(communityComment);
        if (b){
            communityCountMapper.updateCommunityCommentNum(1,communityComment.getCommunityId());
        }
        return b;
    }

    @Override
    public List<CommunityUserCommentVo> findCommunityUserCommentList(int communityId, int page, int count) {
        return communityCommentMapper.findCommunityUserCommentList(communityId,CommonUtil.getPageIndex(page,count),count);
    }

}

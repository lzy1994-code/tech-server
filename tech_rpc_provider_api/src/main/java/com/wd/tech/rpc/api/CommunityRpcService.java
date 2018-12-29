package com.wd.tech.rpc.api;

import com.wd.tech.rpc.pojo.Community;
import com.wd.tech.rpc.pojo.CommunityComment;
import com.wd.tech.rpc.vo.*;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 社区Rpc
 * @author: Lzy
 * @create: 2018-09-11 14:30
 **/
public interface CommunityRpcService {

    /**
     * 社区列表
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<CommunityVo> findCommunityList(int userId, int page, int count);

    /**
     * 发布帖子
     * @param userId
     * @param content
     * @param file
     * @return
     */
    int releasePost(int userId,String content,String file);

    /**
     * 删除帖子
     * @param ids
     * @param userId
     * @return
     */
    int deletePost(int userId, List<Integer> ids);

    /**
     * 点赞
     * @param userId
     * @param communityId
     * @return
     */
    boolean addCommunityGreat(int userId, int communityId);

    /**
     * 取消点赞
     * @param userId
     * @param communityId
     * @return
     */
    boolean cancelCommunityGreat(int userId, int communityId);

    /**
     * 社区评论列表
     * @param communityId
     * @param page
     * @param count
     * @return
     */
    List<String> findCommunityCommentList(int communityId, int page, int count);
    /**
     * 社区评论
     * @param userId
     * @param communityId
     * @param content
     * @return
     */
    int  addCommunityComment(int userId, int communityId,String content);

    /**
     * 我的帖子
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<UserPostVo> findMyPostById(int userId, int page,int count);
    /**
     * 查询用户发布的帖子
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<CommunityUserListVo> findUserPostById(int userId, int fromUid, int page, int count);

    /**
     * 用户社区评论列表
     * @param communityId
     * @param page
     * @param count
     * @return
     */
    List<CommunityUserCommentVo> findCommunityUserCommentList(int communityId, int page, int count);
}

package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.CommunityComment;
import com.wd.tech.rpc.vo.CommunityCommentVo;
import com.wd.tech.rpc.vo.CommunityUserCommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 社区评论
 * @author: Lzy
 * @create: 2018-09-05 13:58
 **/
public interface CommunityCommentMapper {

    /**
     * 社区评论列表
     * @param communityId
     * @param index
     * @param count
     * @return
     */
    List<CommunityCommentVo> findCommunityCommentList(@Param("communityId") int communityId, @Param("index") int index, @Param("count") int count);

    /**
     * 社区评论
     * @param communityComment
     * @return
     */
    boolean addCommunityComment(CommunityComment communityComment);

    /**
     * 用户评论列表
     * @param communityId
     * @param index
     * @param count
     * @return
     */
    List<CommunityUserCommentVo> findCommunityUserCommentList(@Param("communityId") int communityId, @Param("index") int index, @Param("count") int count);

}

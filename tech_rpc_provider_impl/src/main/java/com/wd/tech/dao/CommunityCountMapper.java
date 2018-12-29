package com.wd.tech.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @program: tech-rpc
 * @description: 社区统计
 * @author: Lzy
 * @create: 2018-09-05 14:01
 **/
public interface CommunityCountMapper {

    /**
     * 点赞数修改
     * @param praise
     * @param communityId
     */
    void updateCommunityPraiseNum(@Param("praise") int praise, @Param("communityId") int communityId);

    /**
     * 评论数修改
     * @param comment
     * @param communityId
     */
    void updateCommunityCommentNum(@Param("comment") int comment, @Param("communityId") int communityId);

    /**
     * 社区帖子发布成功后，初始化数据
     * @param communityId
     */
    void addCommunityCount(@Param("communityId") int communityId);

}

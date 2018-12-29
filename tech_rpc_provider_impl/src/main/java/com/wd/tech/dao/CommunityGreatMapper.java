package com.wd.tech.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @program: tech-rpc
 * @description: 社区点赞
 * @author: Lzy
 * @create: 2018-09-05 14:03
 **/
public interface CommunityGreatMapper {

    /**
     * 点赞
     * @param userId
     * @param communityId
     * @return
     */
   boolean addCommunityGreat(@Param("userId") int userId,@Param("communityId") int communityId);
     /**
     * 取消点赞
     * @param userId
     * @param communityId
     * @return
     */
    boolean cancelCommunityGreat(@Param("userId") int userId,@Param("communityId") int communityId);

    /**
     * 是否点赞
     * @param userId
     * @param communityId
     * @return
     */
    int whetherCommunityGreat(@Param("userId") int userId,@Param("communityId") int communityId);

}

package com.wd.tech.service;


import org.apache.ibatis.annotations.Param;

/**
 * @program: tech-rpc
 * @description: 社区点赞service
 * @author: Lzy
 * @create: 2018-09-07 15:53
 **/
public interface CommunityGreatService {

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
    boolean cancelCommunityGreat(int userId,int communityId);

    /**
     * 是否点赞
     * @param userId
     * @param communityId
     * @return 1=是 2=否
     */
    int whetherCommunityGreat(int userId,int communityId);


}

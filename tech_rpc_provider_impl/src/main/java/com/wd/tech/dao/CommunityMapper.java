package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.Community;
import com.wd.tech.rpc.vo.CommunityUserPostVo;
import com.wd.tech.rpc.vo.CommunityVo;
import com.wd.tech.rpc.vo.UserPostVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 社区mapper
 * @author: Lzy
 * @create: 2018-09-05 13:54
 **/
public interface CommunityMapper {

    /**
     * 社区列表
     * @param index
     * @param count
     * @return
     */
   List<CommunityVo> findCommunityList(@Param("index") int index, @Param("count") int count);


    /**
     * 发布帖子
     * @param community
     * @return
     */
    int releasePost(Community community);

    /**
     * 删除帖子
     * @param ids
     * @return
     */
    boolean deletePost(@Param("ids") List<Integer> ids);

    /**
     * 判断是否为我的帖子
     * @param userId
     * @param id
     * @return
     */
    int whetherMyPost(@Param("userId") int userId,@Param("id") int id);

    /**
     * 我的帖子
     * @param userId
     * @param index
     * @param count
     * @return
     */
    List<UserPostVo> findMyPostById(@Param("userId") int userId,@Param("index") int index, @Param("count") int count);

    /**
     * 查询用户发布的帖子
     * @param fromUid
     * @param index
     * @param count
     * @return
     */
    List<CommunityUserPostVo> findUserPostById(@Param("fromUid") int fromUid,@Param("index") int index, @Param("count") int count);





}
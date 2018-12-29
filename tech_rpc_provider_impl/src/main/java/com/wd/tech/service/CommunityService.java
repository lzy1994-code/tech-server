package com.wd.tech.service;

import com.wd.tech.rpc.pojo.Community;
import com.wd.tech.rpc.vo.CommunityUserListVo;
import com.wd.tech.rpc.vo.CommunityUserPostVo;
import com.wd.tech.rpc.vo.CommunityVo;
import com.wd.tech.rpc.vo.UserPostVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 社区service
 * @author: Lzy
 * @create: 2018-09-05 15:41
 **/
public interface CommunityService {


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
     * @return
     */
    int deletePost(int userId, List<Integer> ids);
    /**
     * 判断是否为我的帖子
     * @param userId
     * @param id
     * @return
     */
    int whetherMyPost(int userId, int id);

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
    List<CommunityUserPostVo> findUserPostById(int userId,int fromUid,int page, int count);

}

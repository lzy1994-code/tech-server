package com.wd.tech.service;

import com.wd.tech.rpc.pojo.CommunityComment;
import com.wd.tech.rpc.vo.CommunityCommentVo;
import com.wd.tech.rpc.vo.CommunityUserCommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 社区评论
 * @author: Lzy
 * @create: 2018-09-05 16:45
 **/
public interface CommunityCommentService {

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
   boolean addCommunityComment(int userId,int communityId,String content);
   /**
    * 用户社区评论列表
    * @param communityId
    * @param page
    * @param count
    * @return
    */
   List<CommunityUserCommentVo> findCommunityUserCommentList(int communityId, int page, int count);

}

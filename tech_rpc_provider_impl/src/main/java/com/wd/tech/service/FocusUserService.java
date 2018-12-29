package com.wd.tech.service;

import com.wd.tech.rpc.vo.FocusUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户关注service
 * @author: Lzy
 * @create: 2018-09-07 13:45
 **/
public interface FocusUserService {

    /**
     * 用户关注列表
     * @param userId
     * @return
     */
    List<FocusUserVo> findFollowUserList(int userId,int page,int count);
    /**
     * 关注用户
     * @param userId
     * @param focusId
     * @return
     */
    boolean addFollow( int userId,  int focusId);

    /**
     * 用于判断是否是关注用户
     * @param userId
     * @return
     */
    int whetherFollowUser(int userId,int focusId);
    /**
     * 取消关注
     * @param userId
     * @param focusId
     * @return
     */
    boolean cancelFollow( int userId,int focusId);

    /**
     * 是否相互关注
     * @param userId
     * @param focusId
     * @return
     */
    int whetherMutualFollow(int userId,int focusId);


}

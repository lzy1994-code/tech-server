package com.wd.tech.dao;

import com.wd.tech.rpc.vo.FocusUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 关注用户
 * @author: Lzy
 * @create: 2018-09-06 14:36
 **/
public interface FocusUserMapper{
    /**
     * 用户关注列表
     * @param userId
     * @return
     */
    List<FocusUserVo> findFollowUserList(@Param("userId")int userId,@Param("index") int index,@Param("count") int count);

    /**
     * 用于判断是否是关注用户
     * @param userId
     * @return
     */
    int whetherFollowUser(@Param("userId") int userId,@Param("focusId") int focusId);

    /**
     * 关注用户
     * @param userId
     * @param focusId
     * @return
     */
    boolean addFollow(@Param("userId") int userId,@Param("focusId") int focusId);

    /**
     * 取消关注
     * @param userId
     * @param focusId
     * @return
     */
    boolean cancelFollow(@Param("userId") int userId,@Param("focusId") int focusId);

    /**
     * 是否相互关注
     * @param userId
     * @param focusId
     * @return
     */
    int whetherMutualFollow(@Param("userId") int userId,@Param("focusId") int focusId);
}

package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.InfoGreat;
import org.apache.ibatis.annotations.Param;

/**
 * @program: tech-rpc
 * @description: 资讯点赞dao
 * @author: Lzy
 * @create: 2018-08-28 15:55
 **/
public interface InfoGreatMapper {
    /**
     * 添加点赞记录
     * @param userId
     * @param infoId
     * @return
     */
     boolean addGreatRecord(@Param("userId") int userId,@Param("infoId") int infoId);

    /**
     * 用户是否对该资讯点过赞
     * @param userId
     * @param infoId
     * @return
     */
     int whetherInfoGreat(@Param("userId") int userId,@Param("infoId") int infoId);

    /**
     * 取消点赞
     * @param userId
     * @param infoId
     * @return
     */
     boolean cancelGreat(@Param("userId") int userId,@Param("infoId") int infoId);

}

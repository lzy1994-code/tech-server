package com.wd.tech.service;

import com.wd.tech.rpc.pojo.InfoGreat;
import org.apache.ibatis.annotations.Param;

/**
 * @program: tech-rpc
 * @description: 资讯点赞service
 * @author: Lzy
 * @create: 2018-08-31 14:22
 **/
public interface InfoGreatService {
    /**
     * 添加点赞记录
     * @param userId
     * @param infoId
     * @return
     */
     boolean addGreatRecord( int userId,int infoId);
    /**
     * 取消点赞
     * @param userId
     * @param infoId
     * @return
     */
    boolean cancelGreat(int userId, int infoId);
    /**
     * 用户是否对该资讯点过赞
     * @param userId
     * @param infoId
     * @return
     */
    int whetherInfoGreat( int userId,int infoId);

}

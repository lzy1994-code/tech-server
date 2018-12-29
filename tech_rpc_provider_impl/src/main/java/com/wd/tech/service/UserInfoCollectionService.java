package com.wd.tech.service;

import com.wd.tech.rpc.pojo.UserInfoCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户收藏service
 * @author: Lzy
 * @create: 2018-08-31 17:49
 **/
public interface UserInfoCollectionService {
    /**
     * 用户收藏列表
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<UserInfoCollection> findAllInfoCollection(int userId, int page, int count);

    /**
     * 添加收藏
     * @param userId
     * @param infoId
     * @return
     */
    boolean addCollection(int userId,int infoId);
    /**
     * 取消收藏
     * @param userId
     * @param infoIds
     * @return
     */
    boolean cancelCollection(int userId,List<Integer> infoIds);
    /**
     * 是否收藏
     * @param userId
     * @param infoId
     * @return
     */
    int  whetherCollection(int userId, int infoId);

}

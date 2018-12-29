package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.UserInfoCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户资讯收藏
 * @author: Lzy
 * @create: 2018-08-29 10:51
 **/
public interface UserInfoCollectionMapper {

    /**
     * 用户收藏列表
     * @param userId
     * @param index
     * @param count
     * @return
     */
    List<UserInfoCollection> findAllInfoCollection(@Param("userId") int userId, @Param("index") int index, @Param("count") int count);

    /**
     * 添加收藏
     * @param userId
     * @param infoId
     * @return
     */
    boolean addCollection(@Param("userId") int userId ,@Param("infoId") int infoId);
    /**
     * 取消收藏
     * @param userId
     * @param infoIds
     * @return
     */
   boolean cancelCollection(@Param("userId") int userId,@Param("infoIds") List<Integer> infoIds);
    /**
     * 是否收藏
     * @param userId
     * @param infoId
     * @return
     */
   int  whetherCollection(@Param("userId") int userId,@Param("infoId") int infoId);

}

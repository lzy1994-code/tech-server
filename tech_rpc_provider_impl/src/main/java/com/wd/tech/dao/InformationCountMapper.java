package com.wd.tech.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @program: tech-rpc
 * @description: 资讯信息统计
 * @author: Lzy
 * @create: 2018-08-29 14:25
 **/
public interface InformationCountMapper {


    /**
     * 修改资讯收藏数
     * @param collection
     * @param infoId
     */
     void updateInfoCollectionNum(@Param("collection") int collection,@Param("infoId") int infoId);

    /**
     * 修改资讯点赞数
     * @param praise
     * @param infoId
     */
     void updateInfoPraiseNum(@Param("praise") int praise,@Param("infoId") int infoId);


    /**
     * 修改资讯评论数
     * @param infoId
     */
     void updateInfoCommentNum(int infoId);


    /**
     * 修改资讯分享数
     * @param infoId
     */
    boolean updateInfoShareNum(int infoId);



}

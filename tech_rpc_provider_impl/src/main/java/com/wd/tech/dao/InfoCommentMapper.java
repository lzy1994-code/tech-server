package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.InfoComment;
import com.wd.tech.rpc.vo.InfoCommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 资讯评论dao
 * @author: Lzy
 * @create: 2018-08-28 15:51
 **/
public interface InfoCommentMapper {

    /**
     * 用户评论
     * @param infoComment
     * @return
     */
    public boolean addInfoComment(InfoComment infoComment);

    /**
     * 查询资讯评论列表
     * @param infoId
     * @return
     */
    public List<InfoCommentVo> findAllInfoComment(@Param("infoId") int infoId, @Param("index") int index, @Param("count") int count);

}

package com.wd.tech.service;

import com.wd.tech.rpc.pojo.InfoComment;
import com.wd.tech.rpc.vo.InfoCommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户评论service
 * @author: Lzy
 * @create: 2018-08-31 09:33
 **/
public interface InfoCommentService {
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
    public List<InfoCommentVo> findAllInfoComment(int infoId, int page, int count);


}

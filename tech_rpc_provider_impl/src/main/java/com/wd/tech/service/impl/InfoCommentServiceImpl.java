package com.wd.tech.service.impl;

import com.wd.tech.dao.InfoCommentMapper;
import com.wd.tech.dao.InformationCountMapper;
import com.wd.tech.rpc.pojo.InfoComment;
import com.wd.tech.rpc.vo.InfoCommentVo;
import com.wd.tech.service.InfoCommentService;
import com.wd.tech.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户评论实现类
 * @author: Lzy
 * @create: 2018-08-31 09:34
 **/
@Service("infoCommentService")
public class InfoCommentServiceImpl implements InfoCommentService {

    @Resource
    private InfoCommentMapper infoCommentMapper;

    @Resource
    private InformationCountMapper informationCountMapper;


    /**
     * 用户评论
     * @param infoComment
     * @return
     */
    @Override
    public boolean addInfoComment(InfoComment infoComment) {
        //用户评论
      boolean boo =  infoCommentMapper.addInfoComment(infoComment);
        //评论成功后，统计表中对应资讯评论数+1
      if (boo){
          informationCountMapper.updateInfoCommentNum(infoComment.getInfoId());
      }
        return boo;
    }

    /**
     * 查询资讯评论列表
     * @param infoId
     * @param page
     * @param count
     * @return
     */
    @Override
    public List<InfoCommentVo> findAllInfoComment(int infoId, int page, int count) {
        return infoCommentMapper.findAllInfoComment(infoId, CommonUtil.getPageIndex(page,count),count);
    }


}

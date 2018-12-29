package com.wd.tech.service.impl;

import com.wd.tech.dao.InfoGreatMapper;
import com.wd.tech.dao.InformationCountMapper;
import com.wd.tech.rpc.pojo.InfoGreat;
import com.wd.tech.service.InfoGreatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: tech-rpc
 * @description: 资讯点赞实现类
 * @author: Lzy
 * @create: 2018-08-31 14:24
 **/
@Service("infoGreatService")
public class InfoGreatServiceImpl implements InfoGreatService {

    @Resource
    private InfoGreatMapper infoGreatMapper;

    @Resource
    private InformationCountMapper informationCountMapper;

    /**
     * 添加点赞记录
     * @param userId
     * @param infoId
     * @return
     */
    @Override
    public boolean addGreatRecord(int userId,int infoId) {
        int result = whetherInfoGreat(userId, infoId);
        if(InfoGreat.WHETHER_GREAT_YES == result)
        {
            return false;
        }
        boolean boo = infoGreatMapper.addGreatRecord(userId,infoId);
        if (boo){
            //修改资讯数据点赞数
            informationCountMapper.updateInfoPraiseNum(1,infoId);
        }
        return  boo;
    }

    /**
     * 取消点赞
     *
     * @param userId
     * @param infoId
     * @return
     */
    @Override
    public boolean cancelGreat(int userId, int infoId) {
        boolean boo = infoGreatMapper.cancelGreat(userId, infoId);
        if (boo){
            informationCountMapper.updateInfoPraiseNum(-1,infoId);
        }
        return boo;
    }

    @Override
    public int whetherInfoGreat(int userId, int infoId) {
        int num = infoGreatMapper.whetherInfoGreat(userId, infoId);
        if (num == 0) {
            return InfoGreat.WHETHER_GREAT_NO;
        }else {
            return InfoGreat.WHETHER_GREAT_YES;
        }
    }

}

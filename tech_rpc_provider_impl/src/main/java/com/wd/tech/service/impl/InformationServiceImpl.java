package com.wd.tech.service.impl;

import com.wd.tech.dao.*;
import com.wd.tech.rpc.pojo.Information;
import com.wd.tech.rpc.pojo.InformationPlate;
import com.wd.tech.rpc.vo.InformationListVo;
import com.wd.tech.rpc.vo.InformationVagueVo;
import com.wd.tech.rpc.vo.InformationVo;
import com.wd.tech.rpc.vo.RecommendReadVo;
import com.wd.tech.service.InfoGreatService;
import com.wd.tech.service.InformationService;
import com.wd.tech.service.UserInfoCollectionService;
import com.wd.tech.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 资讯实现类
 * @author: Lzy
 * @create: 2018-08-28 17:59
 **/
@Service("informationService")
public class InformationServiceImpl implements InformationService {

    @Resource
    private InformationMapper informationMapper;
    @Resource
    private InformationPlateMapper informationPlateMapper;
    @Resource
    private InfoGreatService infoGreatService;
    @Resource
    private UserInfoCollectionService userInfoCollectionService;
    @Resource
    private InfoPayRecordMapper infoPayRecordMapper;

    /**
     * 资讯推荐展示列表(包含单独板块列表展示)
     * @param userId
     * @param plateId
     * @param page
     * @param count
     * @return
     */
    @Override
    public List<InformationListVo> infoRecommendList(int userId,int plateId,int page, int count) {
        List<InformationListVo> informationListVoList = new ArrayList<>();
        if (plateId>0){
            informationListVoList  = informationMapper.findInformationByPlate(plateId,CommonUtil.getPageIndex(page,count),count);
        }else {
            informationListVoList =  informationMapper.infoRecommendList(CommonUtil.getPageIndex(page,count),count);
        }
        for (InformationListVo informationListVo:informationListVoList) {
            informationListVo.setWhetherPay(whetherPay(informationListVo.getId()));
            informationListVo.setWhetherCollection(userInfoCollectionService.whetherCollection(userId,informationListVo.getId()));
        }
        return informationListVoList;
    }
    /**
     * 资讯详情展示
     * @param userId
     * @param id
     * @return
     */
    @Override
    public InformationVo findInformationDetails(int userId,int id) {
        InformationVo informationVo = null ;
        int count = infoPayRecordMapper.whetherUserPay(userId, id);
        int whetherPay = whetherPay(id);
        if (whetherPay == 1 && count == 0){
            informationVo = informationMapper.findInformationPay(id);
            informationVo.setWhetherGreat(infoGreatService.whetherInfoGreat(userId,id));
            informationVo.setWhetherCollection(userInfoCollectionService.whetherCollection(userId,id));
        }else {
            informationVo = informationMapper.findInformationDetails(id);
            List<RecommendReadVo> recommendReadList = new ArrayList<>();
            //获取推荐阅读id
            String relatedArticles = informationVo.getRelatedArticles();
            String [] infoIds = relatedArticles.split(",");
            for (int i = 0 ;i< infoIds.length;i++){
                int infoId  = Integer.valueOf(infoIds[i]);
                RecommendReadVo recommendRead = informationMapper.recommendReads(infoId);
                recommendReadList.add(recommendRead);
            }
            informationVo.setInformationList(recommendReadList);
            informationVo.setWhetherGreat(infoGreatService.whetherInfoGreat(userId,id));
            informationVo.setWhetherCollection(userInfoCollectionService.whetherCollection(userId,id));
            //所属板块
            List<InformationPlate> informationPlates  = informationPlateMapper.findPlateNameById(id);
            informationVo.setPlate(informationPlates);
        }
        return informationVo;
    }

    @Override
    public List<InformationVagueVo> findInformationByTitle(String title,int page,int count) {
        return informationMapper.findInformationByTitle(title,CommonUtil.getPageIndex(page, count),count);
    }

    @Override
    public int whetherPay(int id) {
        Information information = informationMapper.whetherPay(id);
        if (information.getIntegralCost() == 0 &&  information.getYuanCost()==0 ){
            return Information.WHETHER_PAY_NO;
        }
        return Information.WHETHER_PAY_YES;
    }


    @Override
    public List<InformationVagueVo> findInformationBySource(String source, int page, int count) {
        return informationMapper.findInformationBySource(source,CommonUtil.getPageIndex(page, count),count);
    }

}

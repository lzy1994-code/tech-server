package com.wd.tech.rpc.impl;

import com.wd.tech.rpc.api.InformationRpcService;
import com.wd.tech.rpc.pojo.*;
import com.wd.tech.rpc.vo.*;
import com.wd.tech.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 资讯rpc实现类
 * @author: Lzy
 * @create: 2018-08-29 15:02
 **/
@Service("informationRpcService")
public class InformationRpcServiceImpl implements InformationRpcService {

    @Resource
    private BannersService bannersService;
    @Resource
    private InformationService informationService;

    @Resource
    private InformationPlateService informationPlateService;

    @Resource
    private InformationCountService informationCountService;

    @Resource
    private InfoGreatService infoGreatService;

    @Resource
    private InfoCommentService infoCommentService;

    @Resource
    private InfoAdvertisingService infoAdvertisingService;


    @Override
    public List<BannersVo> bannerShow() {
        List<BannersVo> banners = bannersService.bannerShow();
        if (banners.isEmpty()){
            return new ArrayList<>();
        }
        return banners;
    }

    @Override
    public List<InformationListVo> infoRecommendList(int userId, int plateId, int page, int count) {
        List<InformationListVo> information = informationService.infoRecommendList(userId,plateId,page,count);
        if (information.isEmpty()){
            return new ArrayList<>();
        }
        return information;
    }

    @Override
    public InformationVo findInformationDetails(int userId,int id) {
        InformationVo informationDetails = informationService.findInformationDetails(userId, id);
        if (informationDetails==null){
            return null;
        }
        return informationDetails;
    }

    @Override
    public List<InformationPlate> findAllInfoPlate() {
        List<InformationPlate> allInfoPlate = informationPlateService.findAllInfoPlate();
        if (allInfoPlate.isEmpty()){
            return new ArrayList<>();
        }
        return allInfoPlate;
    }

    @Override
    public boolean updateInfoShareNum(int infoId) {
      return   informationCountService.updateInfoShareNum(infoId);
    }

    @Override
    public boolean addGreatRecord(int userId, int infoId) {
        return infoGreatService.addGreatRecord(userId,infoId);
    }

    @Override
    public boolean cancelGreat(int userId, int infoId) {
        return infoGreatService.cancelGreat(userId,infoId);
    }

    @Override
    public boolean addInfoComment(InfoComment infoComment) {
        return infoCommentService.addInfoComment(infoComment);
    }

    @Override
    public List<InfoCommentVo> findAllInfoComment(int infoId, int page, int count) {
        List<InfoCommentVo> allInfoComment = infoCommentService.findAllInfoComment(infoId, page, count);
        if (allInfoComment.isEmpty()){
            return new ArrayList<>();
        }
        return allInfoComment;
    }


    @Override
    public InfoAdvertisingVo findInfoAdvertising() {
        InfoAdvertisingVo infoAdvertising = infoAdvertisingService.findInfoAdvertising();
        if (infoAdvertising==null){
            return null;
        }
        return infoAdvertising;
    }

    @Override
    public List<InformationVagueVo> findInformationByTitle(String title, int page, int count) {
        List<InformationVagueVo> informationByTitle = informationService.findInformationByTitle(title, page, count);
        if (informationByTitle.isEmpty()){
            return new ArrayList<>();
        }
        return informationByTitle;
    }
    @Override
    public List<InformationVagueVo> findInformationBySource(String source, int page, int count) {
        List<InformationVagueVo> informationBySource = informationService.findInformationBySource(source, page, count);
        if (informationBySource.isEmpty()){
            return new ArrayList<>();
        }
        return informationBySource;
    }

}

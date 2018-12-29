package com.wd.tech.rpc.impl;

import com.bw.pay.client.api.TechPayRpcService;
import com.wd.tech.rpc.api.ToolRpcService;
import com.wd.tech.rpc.pojo.*;
import com.wd.tech.rpc.vo.CommodityListVo;
import com.wd.tech.rpc.vo.PrizeVo;
import com.wd.tech.rpc.vo.UserLotteryRecordVo;
import com.wd.tech.rpc.vo.WinningVo;
import com.wd.tech.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 辅助相关实现
 * @author: Lzy
 * @create: 2018-09-15 09:53
 **/
@Service("techToolRpcService")
public class ToolRpcServiceImpl implements ToolRpcService {

    private Logger logger = LoggerFactory.getLogger("techToolRpcService");

    @Resource
    private UserVipService userVipService;

    @Resource
    private CommodityService commodityService;

    @Resource
    private TechPayRpcService techPayRpcService;

    @Resource
    private UserVipRecordService userVipRecordService;

    @Resource
    private UserLotteryRecordService userLotteryRecordService;

    @Resource
    private PrizeService prizeService;

    @Resource
    private AppVersionService appVersionService;

    @Resource
    private FeedBackService feedBackService;
    @Resource
    private SysNoticeService sysNoticeService;

    @Override
    public List<CommodityListVo> findVipCommodityList() {

        List<Commodity> list = commodityService.findAllByType(Commodity.TYPE_VIP);
        List<CommodityListVo> result = new ArrayList<>();
        if(list == null)
        {
            return result;
        }

        CommodityListVo vo;
        for(Commodity temp:list)
        {
            vo = new CommodityListVo();
            vo.setCommodityId(temp.getId());
            vo.setCommodityName(temp.getName());
            vo.setPrice(temp.getPrice());
            vo.setImageUrl(temp.getImageUrl());
            result.add(vo);
        }

        return result;
    }

    @Override
    public String buyVip(int userId, int commodityId) {
        try {
            Commodity commodity = commodityService.getCommodity(commodityId);
            if(commodity == null)
            {
                logger.error("没有查询到对应的VIP商品信息");
                return null;
            }

            //创建订单
            String orderId = techPayRpcService.createOrder(2, commodity.getPrice());

            //增加购买VIP记录
            userVipRecordService.addUserVipRecord(userId,orderId,commodityId,commodity.getPrice());

            return orderId;
        } catch (Exception e) {
            logger.error("buyVip",e);
            return null;
        }
    }

    @Override
    public String pay(String orderId, int payType, String ip) {
        try {
            return techPayRpcService.pay(orderId, payType, ip);
        } catch (Exception e) {
            logger.error("pay",e);
            return null;
        }
    }

    @Override
    public int openVip(String orderId) {
        try {
            UserVipRecord record = userVipRecordService.getUserVipRecordByOrderId(orderId);
            if(record == null)
            {
                logger.error("没找查询到对应的订单记录");
                return 0;
            }

            Commodity commodity = commodityService.getCommodity(record.getCommodityId());
            if(commodity == null)
            {
                logger.error("没找查询到对应的商品信息");
                return 0;
            }

            userVipService.openVip(record.getUserId(),commodity.getValue());

            userVipRecordService.modifyPayStatus(orderId);

            return 1;
        } catch (Exception e) {
            logger.error("openVip",e);
            return 0;
        }
    }

    @Override
    public List<PrizeVo> findAllPrize() {
        List<Prize> allPrize = prizeService.findAllPrize();
        List<PrizeVo> result = new ArrayList<>();
        PrizeVo vo;
        for(Prize prize:allPrize)
        {
            vo = new PrizeVo();
            vo.setPrizeId(prize.getId());
            vo.setPrizeName(prize.getName());
            vo.setPrizePic(prize.getPic());
            result.add(vo);
        }
        return result;
    }

    @Override
    public WinningVo lottery(int userId) {
        return prizeService.lottery(userId);
    }

    @Override
    public List<UserLotteryRecordVo> findLotteryRecordList(int userId, int page, int count) {

        List<UserLotteryRecord> pageList = userLotteryRecordService.findPageList(userId, page, count);
        if(pageList == null || pageList.size() == 0)
        {
            return new ArrayList<>();
        }

        List<UserLotteryRecordVo> result = new ArrayList<>();
        UserLotteryRecordVo vo;
        for(UserLotteryRecord temp:pageList)
        {
            vo = new UserLotteryRecordVo();
            vo.setPrizeName(temp.getPrizeName());
            vo.setLotteryTime(temp.getLotteryTime());
            vo.setPrizeValue(temp.getPrizeValue());
            vo.setRecordId(temp.getId());
            vo.setStatus(temp.getStatus());
            result.add(vo);
        }
        return result;
    }

    @Override
    public int receivePrize(int recordId, int userId) {
        return userLotteryRecordService.receivePrize(recordId, userId);
    }

    @Override
    public int recordFeedBack(int userId, String content) {
        return feedBackService.recordFeedBack(userId, content);
    }

    @Override
    public AppVersion findNewAk() {
        return appVersionService.findNewAk();
    }

    @Override
    public List<SysNotice> findSysNoticeList(int userId, int page, int count) {
        List<SysNotice> sysNoticeList = sysNoticeService.findSysNoticeList(userId, page, count);
        if (sysNoticeList.isEmpty()){
            return new ArrayList<>();
        }
        return sysNoticeList;
    }
}

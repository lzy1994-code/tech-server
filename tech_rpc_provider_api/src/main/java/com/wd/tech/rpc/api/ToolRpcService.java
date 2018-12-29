package com.wd.tech.rpc.api;

import com.wd.tech.rpc.pojo.AppVersion;
import com.wd.tech.rpc.pojo.SysNotice;
import com.wd.tech.rpc.vo.CommodityListVo;
import com.wd.tech.rpc.vo.PrizeVo;
import com.wd.tech.rpc.vo.UserLotteryRecordVo;
import com.wd.tech.rpc.vo.WinningVo;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 辅助相关
 * @author: Lzy
 * @create: 2018-09-15 09:52
 **/
public interface ToolRpcService {

    /**
     *  查询所有会员商品
     * @return
     */
    List<CommodityListVo> findVipCommodityList();

    /**
     *  购买会员
     * @param userId
     * @param commodityId
     * @return
     */
    String buyVip(int userId,int commodityId);

    /**
     * 支付
     * @param orderId
     * @param payType
     * @param ip
     * @return
     */
    String pay(String orderId,int payType,String ip);

    /**
     *  开通、续费VIP
     * @param orderId
     * @return
     */
    int openVip(String orderId);

    /**
     *  查询所有奖品
     * @return
     */
    List<PrizeVo> findAllPrize();

    /**
     *  抽奖
     * @param userId
     * @return
     */
    WinningVo lottery(int userId);

    /**
     *  查询用户抽奖记录
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<UserLotteryRecordVo> findLotteryRecordList(int userId, int page, int count);

    /**
     *  领取奖品
     * @param recordId
     * @param userId
     * @return
     */
    int receivePrize(int recordId,int userId);

    /**
     *  记录用户反馈
     * @param userId
     * @param content
     * @return
     */
    int recordFeedBack(int userId,String content);

    /**
     * 查询最新AK
     * @return
     */
    AppVersion findNewAk();

    /**
     * 查询用户系统通知
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<SysNotice> findSysNoticeList(int userId, int page, int count);

}

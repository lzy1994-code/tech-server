package com.wd.tech.service.impl;

import com.wd.tech.dao.PrizeMapper;
import com.wd.tech.rpc.pojo.Prize;
import com.wd.tech.rpc.pojo.UserIntegral;
import com.wd.tech.rpc.vo.WinningVo;
import com.wd.tech.service.PrizeService;
import com.wd.tech.service.UserIntegralService;
import com.wd.tech.service.UserLotteryRecordService;
import com.wd.tech.service.async.RefreshUserThread;
import com.wd.tech.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by xyj on 2018/9/28.
 */
@Service("prizeService")
public class PrizeServiceImpl implements PrizeService {

    private Logger logger = LoggerFactory.getLogger("prizeService");

    @Resource
    private PrizeMapper prizeMapper;

    @Resource
    private UserIntegralService userIntegralService;

    @Resource
    private UserLotteryRecordService userLotteryRecordService;

    @Override
    public List<Prize> findAllPrize() {
        return prizeMapper.findAllPrize();
    }

    @Override
    public WinningVo lottery(int userId) {
        WinningVo result = new WinningVo();
        try {
            //查询用户积分是否足够抽奖
            int integral = userIntegralService.findIntegralNum(userId);
            if(integral < Constants.LOTTERY_USE_INTEGRAL)
            {
                result.setStatus("1001");
                result.setMessage("抽奖失败,您的积分不足");
                return result;
            }

            //查询所有奖品
            List<Prize> allPrize = findAllPrize();

            //随机选取一个奖品
            Prize prize = getPrizeIndex(allPrize);

            //增加用户抽奖记录
            userLotteryRecordService.addUserLotteryRecord(userId,prize.getName(),prize.getId(),prize.getValue());

            //扣除用户对应积分
            userIntegralService.integralChange(userId,Constants.LOTTERY_USE_INTEGRAL, UserIntegral.TYPE_CJZC,UserIntegral.DIRECTION_ZC,null);

            //刷新缓存
            RefreshUserThread.refreshCacheUser(userId);

            result.setPrizeId(prize.getId());
            result.setPrizeName(prize.getName());
            result.setPrizePic(prize.getPic());
            result.setStatus("0000");
            result.setMessage(String.format(Constants.LOTTERY_MESSAGE,prize.getName()));
            return result;
        } catch (Exception e) {
            logger.error("lottery",e);
            result.setStatus("1001");
            result.setMessage("抽奖失败,系统异常");
            return result;
        }
    }

    @Override
    public Prize getPrizeById(int prizeId) {
        return prizeMapper.getPrizeById(prizeId);
    }

    private Prize getPrizeIndex(List<Prize> prizes) {
        DecimalFormat df = new DecimalFormat("######0.00");
        int random = -1;
        try{
            //计算总权重
            double sumWeight = 0;
            for(Prize p : prizes){
                sumWeight += p.getWeight();
            }

            //产生随机数
            double randomNumber;
            randomNumber = Math.random();

            //根据随机数在所有奖品分布的区域并确定所抽奖品
            double d1 = 0;
            double d2 = 0;
            for(int i=0;i<prizes.size();i++){
                d2 += Double.parseDouble(String.valueOf(prizes.get(i).getWeight()))/sumWeight;
                if(i==0){
                    d1 = 0;
                }else{
                    d1 +=Double.parseDouble(String.valueOf(prizes.get(i-1).getWeight()))/sumWeight;
                }
                if(randomNumber >= d1 && randomNumber <= d2){
                    random = i;
                    break;
                }
            }
        }catch(Exception e){
            logger.error("生成抽奖随机数出错，出错原因={}",e);
        }
        return prizes.get(random);
    }

}

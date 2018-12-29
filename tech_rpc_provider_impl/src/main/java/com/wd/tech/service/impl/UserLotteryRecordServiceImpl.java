package com.wd.tech.service.impl;

import com.wd.tech.dao.UserLotteryRecordMapper;
import com.wd.tech.rpc.pojo.Prize;
import com.wd.tech.rpc.pojo.UserIntegral;
import com.wd.tech.rpc.pojo.UserLotteryRecord;
import com.wd.tech.service.PrizeService;
import com.wd.tech.service.UserIntegralService;
import com.wd.tech.service.UserLotteryRecordService;
import com.wd.tech.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xyj on 2018/9/28.
 */
@Service("userLotteryRecordService")
public class UserLotteryRecordServiceImpl implements UserLotteryRecordService {

    private Logger logger = LoggerFactory.getLogger("userLotteryRecordService");

    @Resource
    private UserLotteryRecordMapper userLotteryRecordMapper;

    @Resource
    private PrizeService prizeService;

    @Resource
    private UserIntegralService userIntegralService;

    @Override
    public int addUserLotteryRecord(int userId,String prizeName,int prizeId,int prizeValue) {
        UserLotteryRecord userLotteryRecord = new UserLotteryRecord();
        userLotteryRecord.setUserId(userId);
        userLotteryRecord.setStatus(UserLotteryRecord.STATUS_DLQ);
        userLotteryRecord.setPrizeName(prizeName);
        userLotteryRecord.setPrizeId(prizeId);
        userLotteryRecord.setPrizeValue(prizeValue);
        userLotteryRecord.setLotteryTime(new Date());
        return userLotteryRecordMapper.addUserLotteryRecord(userLotteryRecord);
    }

    @Override
    public List<UserLotteryRecord> findPageList(int userId, int index, int count) {
        List<UserLotteryRecord> pageList = userLotteryRecordMapper.findPageList(userId, CommonUtil.getPageIndex(index, count), count);
        if(pageList == null)
        {
            pageList = new ArrayList<>();
        }
        return pageList;
    }

    @Override
    public int receivePrize(int recordId, int userId) {

        try {
            //查询获奖记录
            UserLotteryRecord userLotteryRecord = userLotteryRecordMapper.getUserLotteryRecord(recordId);
            if(userLotteryRecord == null)
            {
                return 0;
            }

            Prize prize = prizeService.getPrizeById(userLotteryRecord.getPrizeId());

            //如果是虚拟奖品
            if(prize.getType() == Prize.TYPE_XN)
            {
                //如果是谢谢惠顾则不处理
                if(prize.getValue() == 0)
                {
                    return 1;
                }

                //用户积分处理
                userIntegralService.integralChange(userId,prize.getValue(), UserIntegral.TYPE_CJSR,UserIntegral.DIRECTION_SR,null);
            }

            //如果是实物则直接改个状态就可以了~
            userLotteryRecordMapper.updateRecordStatus(recordId, userId);

            return 1;
        } catch (Exception e) {
            logger.error("receivePrize",e);
            return 0;
        }
    }
}

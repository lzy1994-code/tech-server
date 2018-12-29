package com.wd.tech.service;

import com.wd.tech.rpc.pojo.UserIntegral;

/**
 * @program: tech-rpc
 * @description: 用户积分
 * @author: Lzy
 * @create: 2018-09-03 10:38
 **/
public interface UserIntegralService {

    /**
     * 查询用户积分
     * @param userId
     * @return
     */
    UserIntegral findUserIntegral(int userId);

    /**
     * 通过用户id查询积分余额（用于积分明细）
     * @param userId
     * @return
     */
    int findIntegralNum(int userId);

    /**
     *  积分变动业务
     * @param userId
     * @param amount 积分额度
     * @param type 1=签到  2=评论  3=分享 4=发帖  5=抽奖收入  6=付费资讯  7=抽奖支出  8=完善个人信息(单次奖励)
     * @param direction 1=收入  2=支出
     * @param remark 备注信息
     * @return
     */
    int integralChange(int userId,int amount,int type,int direction,String remark);

}

package com.wd.tech.service;

import com.wd.tech.rpc.pojo.Prize;
import com.wd.tech.rpc.vo.WinningVo;

import java.util.List;

/**
 * Created by xyj on 2018/9/28.
 */
public interface PrizeService {

    /**
     *  查询所有奖品
     * @return
     */
    List<Prize> findAllPrize();

    /**
     *  抽奖
     * @param userId
     * @return
     */
    WinningVo lottery(int userId);

    Prize getPrizeById(int prizeId);

}

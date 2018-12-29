package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.Prize;

import java.util.List;

/**
 * Created by xyj on 2018/9/28.
 */
public interface PrizeMapper {

    List<Prize> findAllPrize();

    Prize getPrizeById(int prizeId);

}

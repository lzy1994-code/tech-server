package com.wd.tech.service;

import com.wd.base.BaseTest;
import com.wd.tech.rpc.pojo.Prize;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xyj on 2018/9/28.
 */
@Ignore
public class PrizeServiceTest extends BaseTest {

    @Resource
    private PrizeService prizeService;

    @Test
    public void findAllPrize() {
        List<Prize> allPrize = prizeService.findAllPrize();
        System.out.println(allPrize);
    }

    @Test
    public void lottery() {

        System.out.println(prizeService.lottery(1001));

    }
}
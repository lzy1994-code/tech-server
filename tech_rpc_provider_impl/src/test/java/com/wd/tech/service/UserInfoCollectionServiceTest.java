package com.wd.tech.service;

import com.wd.base.BaseTest;
import com.wd.tech.rpc.pojo.UserInfoCollection;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Ignore
public class UserInfoCollectionServiceTest extends BaseTest {


    @Resource
    private UserInfoCollectionService userInfoCollectionService;

    @Test
    public void findAllInfoCollection() {
        List<UserInfoCollection> allInfoCollection = userInfoCollectionService.findAllInfoCollection(1000, 1, 5);
        System.out.println(allInfoCollection);
    }

    @Test
    public void addCollection() {

    }

    @Test
    public void cancelCollection() {
        List<Integer> infoIds = new ArrayList<>();
        infoIds.add(22);
        infoIds.add(18);
        boolean b = userInfoCollectionService.cancelCollection(1000, infoIds);
        System.out.println(b);
    }
}
package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@Ignore
public class CommunityGreatServiceTest extends BaseTest {

    @Resource
    private CommunityGreatService communityGreatService;

    @Test
    public void addCommunityGreat() {
        boolean b = communityGreatService.addCommunityGreat(1010, 14);
        System.out.println(b);
    }

    @Test
    public void cancelCommunityGreat() {
        boolean b = communityGreatService.cancelCommunityGreat(1010, 14);
        System.out.println(b);
    }

    @Test
    public void whetherCommunityGreat() {
        int i = communityGreatService.whetherCommunityGreat(1010, 14);
        System.out.println(i);
    }
}
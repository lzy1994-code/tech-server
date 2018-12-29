package com.wd.tech.service;

import com.wd.base.BaseTest;
import com.wd.tech.rpc.vo.CommunityVo;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Ignore
public class CommunityServiceTest extends BaseTest {

    @Resource
    private CommunityService communityService;

    @Test
    public void findCommunityList() {
        List<CommunityVo> communityList = communityService.findCommunityList(1018, 1, 5);
        System.out.println(communityList);
    }
    @Test
    public void releasePost(){
        int i = communityService.releasePost(1012, "首发", "http://172.17.8.100/images/tech/head_pic/2018-09-20/20180920081958.jpg");
        System.out.println(i);
    }
    @Test
    public void delPost(){
        List<Integer> ids = new ArrayList<>();
        ids.add(555);
        int b = communityService.deletePost(1018,ids);
        System.out.println(b);
    }
}
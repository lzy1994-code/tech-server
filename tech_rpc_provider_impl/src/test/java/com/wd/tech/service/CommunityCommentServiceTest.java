package com.wd.tech.service;

import com.wd.base.BaseTest;
import com.wd.tech.rpc.vo.CommunityCommentVo;
import com.wd.tech.rpc.vo.CommunityUserCommentVo;
import com.wd.tech.util.CommonUtil;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

@Ignore
public class CommunityCommentServiceTest extends BaseTest {

    @Resource
    private CommunityCommentService communityCommentService;

    @Test
    public void findCommunityCommentList() {
        List<String> communityCommentList = communityCommentService.findCommunityCommentList(1, 1, 5);
        System.out.println(communityCommentList);
        for (String source: communityCommentList) {
            List<String> match = CommonUtil.match(source, "comment", "userId");
            System.out.println(match);
        }
    }
    @Test
    public void addCommunityComment(){
        boolean b = communityCommentService.addCommunityComment(1018, 130, "测试");
        System.out.println(b);
    }
    @Test
    public void findCommunityUserCommentList(){
        List<CommunityUserCommentVo> communityUserCommentList = communityCommentService.findCommunityUserCommentList(563, 1, 5);
        System.out.println(communityUserCommentList);
    }
}
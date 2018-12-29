package com.wd.tech.service;

import com.wd.base.BaseTest;
import com.wd.tech.rpc.pojo.InfoComment;
import com.wd.tech.rpc.vo.InfoCommentVo;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

@Ignore
public class InfoCommentServiceTest extends BaseTest {

    @Resource
    private InfoCommentService service;

    @Test
    public void addInfoComment() {
        InfoComment infoComment = new InfoComment();
        infoComment.setInfoId(2);
        infoComment.setUserId(1005);
        infoComment.setContent("今天没雨");
        service.addInfoComment(infoComment);
        System.out.println(infoComment.getId());
    }

    @Test
    public void findAllInfoComment() {
        List<InfoCommentVo> infoCommentList = service.findAllInfoComment(1,1,5);
        System.out.println(infoCommentList);
    }
}
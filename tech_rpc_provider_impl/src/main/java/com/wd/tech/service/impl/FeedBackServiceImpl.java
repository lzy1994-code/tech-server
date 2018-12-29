package com.wd.tech.service.impl;

import com.wd.tech.dao.FeedBackMapper;
import com.wd.tech.rpc.pojo.FeedBack;
import com.wd.tech.service.FeedBackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/7/18.
 */
@Service("feedBackService")
public class FeedBackServiceImpl implements FeedBackService {

    @Resource
    private FeedBackMapper feedBackMapper;

    @Override
    public int recordFeedBack(int userId,String content) {
        FeedBack feedBack = new FeedBack();
        feedBack.setContent(content);
        feedBack.setUserId(userId);
        return feedBackMapper.addFeedBack(feedBack);
    }

}

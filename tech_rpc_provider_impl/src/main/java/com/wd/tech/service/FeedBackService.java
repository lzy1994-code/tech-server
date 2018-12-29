package com.wd.tech.service;

/**
 * Created by xyj on 2018/7/18.
 */
public interface FeedBackService {

    /**
     *  记录用户反馈
     * @param userId
     * @param content
     * @return
     */
    int recordFeedBack(int userId, String content);

}

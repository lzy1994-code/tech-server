package com.wd.tech.service;

import com.wd.tech.rpc.pojo.FriendNotice;

import java.util.List;

/**
 * Created by xyj on 2018/9/5.
 */
public interface FriendNoticeService {

    /**
     *  增加好友通知
     * @param fromUid
     * @param receiveUid
     * @param remark
     * @return
     */
    int increaseFriendNotice(int fromUid, int receiveUid, String remark);

    /**
     * 查询好友通知记录
     * @param receiveUid
     * @param page
     * @param count
     * @return
     */
    List<FriendNotice> findFriendNoticePageList(int receiveUid,int page,int count);

    /**
     * 审核通过
     * @param id
     * @return
     */
    int pass(int id);

    /**
     * 审核驳回
     * @param id
     * @return
     */
    int reject(int id);

    /**
     * 查询最后一条好友通知
     * @param userId
     * @return
     */
    FriendNotice findLastFriendNotice(int userId);

    /**
     *  根据通知ID查询
     * @param id
     * @return
     */
    FriendNotice findFriendNoticeById(int id);

}

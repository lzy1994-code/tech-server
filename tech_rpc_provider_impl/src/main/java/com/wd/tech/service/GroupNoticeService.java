package com.wd.tech.service;

import com.wd.tech.rpc.pojo.GroupNotice;

import java.util.List;

/**
 * Created by xyj on 2018/9/5.
 */
public interface GroupNoticeService {

    /**
     *  申请进群
     * @param groupId
     * @param fromUid
     * @param remark
     * @return
     */
    int applyAddGroup(int groupId,int fromUid,String remark);

    /**
     *  邀请加群
     * @param groupId
     * @param fromUid
     * @param receiverUid
     * @return
     */
    int inviteAddGroup(int groupId,int fromUid,int receiverUid);

    /**
     *  查询群通知
     * @param userId
     * @param page
     * @param count
     * @return
     */
    List<GroupNotice> findGroupNoticePageList(int userId,int page,int count);

    /**
     *  审核通过,群申请调用
     * @param batchNumber
     * @return
     */
    int batchPass(String batchNumber);

    /**
     *  审核驳回,群申请调用
     * @param batchNumber
     * @return
     */
    int batchReject(String batchNumber);

    /**
     *  审核通过
     * @param noticeId
     * @return
     */
    int pass(int noticeId);

    /**
     *  审核驳回
     * @param noticeId
     * @return
     */
    int reject(int noticeId);

    GroupNotice getGroupNoticeById(int noticeId);

    /**
     *  根据群ID清楚群通知信息
     * @param groupId
     * @return
     */
    int deleteByGroupId(int groupId);

}

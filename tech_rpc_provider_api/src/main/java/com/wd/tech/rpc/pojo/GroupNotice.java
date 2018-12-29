package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/5.
 */
public class GroupNotice implements Serializable {

    private static final long serialVersionUID = 7397759982504774987L;

    /**
     *  待处理
     */
    public static int STATUS_DCL = 1;

    /**
     * 通过
     */
    public static int STATUS_TG = 2;

    /**
     * 拒绝
     */
    public static int STATUS_JJ = 3;

    /**
     * 用户申请进群
     */
    public static int TYPE_SQ = 2;

    /**
     * 管理邀请进群
     */
    public static int TYPE_YQ = 1;

    /**
     *  审核通过
     */
    public static int APPLY_PASS = 1;

    /**
     *  审核拒绝
     */
    public static int APPLY_REJECT = 2;

    private int id;
    private String batchNumber;
    private int groupId;
    private int fromUid;
    private int receiverUid;
    private String remark;
    private int status;
    private int type;
    private Date noticeTime;
    private Date checkTime;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getFromUid() {
        return fromUid;
    }

    public void setFromUid(int fromUid) {
        this.fromUid = fromUid;
    }

    public int getReceiverUid() {
        return receiverUid;
    }

    public void setReceiverUid(int receiverUid) {
        this.receiverUid = receiverUid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    @Override
    public String toString() {
        return "GroupNotice{" +
                "id=" + id +
                ", batchNumber='" + batchNumber + '\'' +
                ", groupId=" + groupId +
                ", fromUid=" + fromUid +
                ", receiverUid=" + receiverUid +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", noticeTime=" + noticeTime +
                ", checkTime=" + checkTime +
                ", createTime=" + createTime +
                '}';
    }
}

package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/5.
 */
public class FriendNotice implements Serializable {

    private static final long serialVersionUID = -8894117583616474843L;

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

    private int id;
    private int fromUid;
    private int receiveUid;
    private String remark;
    private int status;
    private Date noticeTime;
    private Date checkTime;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromUid() {
        return fromUid;
    }

    public void setFromUid(int fromUid) {
        this.fromUid = fromUid;
    }

    public int getReceiveUid() {
        return receiveUid;
    }

    public void setReceiveUid(int receiveUid) {
        this.receiveUid = receiveUid;
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

    @Override
    public String toString() {
        return "FriendNotice{" +
                "id=" + id +
                ", fromUid=" + fromUid +
                ", receiveUid=" + receiveUid +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", noticeTime=" + noticeTime +
                ", checkTime=" + checkTime +
                ", createTime=" + createTime +
                '}';
    }
}

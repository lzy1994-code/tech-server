package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/6.
 */
public class FriendNoticeListVo implements Serializable {

    private static final long serialVersionUID = -2580730344781173264L;

    private int noticeId;
    private int fromUid;
    private int receiveUid;
    private String remark;
    private int status;
    private Date noticeTime;
    private String fromNickName;
    private String fromHeadPic;

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

    public String getFromNickName() {
        return fromNickName;
    }

    public void setFromNickName(String fromNickName) {
        this.fromNickName = fromNickName;
    }

    public String getFromHeadPic() {
        return fromHeadPic;
    }

    public void setFromHeadPic(String fromHeadPic) {
        this.fromHeadPic = fromHeadPic;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    @Override
    public String toString() {
        return "FriendNoticeListVo{" +
                "noticeId=" + noticeId +
                ", fromUid=" + fromUid +
                ", receiveUid=" + receiveUid +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", noticeTime=" + noticeTime +
                ", fromNickName='" + fromNickName + '\'' +
                ", fromHeadPic='" + fromHeadPic + '\'' +
                '}';
    }
}

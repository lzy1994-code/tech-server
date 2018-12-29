package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/6.
 */
public class GroupNoticeListVo implements Serializable {

    private static final long serialVersionUID = -8706588048370228492L;

    private int noticeId;
    private String groupName;
    //type为1时 此值为群管理员的昵称    为2时 为申请入群的用户昵称
    private String nickName;
    private String remark;
    private int status;
    private int type;
    private Date noticeTime;
    private String headPic;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    @Override
    public String toString() {
        return "GroupNoticeListVo{" +
                "noticeId=" + noticeId +
                ", groupName='" + groupName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", noticeTime=" + noticeTime +
                ", headPic='" + headPic + '\'' +
                '}';
    }
}

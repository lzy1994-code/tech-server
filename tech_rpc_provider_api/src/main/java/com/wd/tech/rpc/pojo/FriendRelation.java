package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/4.
 */
public class FriendRelation implements Serializable {

    private static final long serialVersionUID = 6862396444827731544L;

    private int id;
    private int userId;
    private int friendUid;
    private int friendGroupId;
    private String remarkName;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendUid() {
        return friendUid;
    }

    public void setFriendUid(int friendUid) {
        this.friendUid = friendUid;
    }

    public int getFriendGroupId() {
        return friendGroupId;
    }

    public void setFriendGroupId(int friendGroupId) {
        this.friendGroupId = friendGroupId;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FriendRelation{" +
                "id=" + id +
                ", userId=" + userId +
                ", friendUid=" + friendUid +
                ", friendGroupId=" + friendGroupId +
                ", remarkName='" + remarkName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

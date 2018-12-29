package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/8/10.
 */
public class UserBindingLogin implements Serializable{

    private static final long serialVersionUID = -6694062834545773722L;

    public static int TYPE_WECHAT = 1;

    private int id;
    private int userId;
    private int type;
    private String openId;
    private String unionId;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserBindingLogin{" +
                "id=" + id +
                ", userId=" + userId +
                ", type=" + type +
                ", openId='" + openId + '\'' +
                ", unionId='" + unionId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

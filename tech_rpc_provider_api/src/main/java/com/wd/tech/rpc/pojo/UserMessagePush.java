package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/8/13.
 */
public class UserMessagePush implements Serializable {

    private static final long serialVersionUID = -8523645853467038433L;

    private int id;
    private int userId;
    private String token;
    private int os;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserMessagePush{" +
                "id=" + id +
                ", userId=" + userId +
                ", token='" + token + '\'' +
                ", os=" + os +
                ", createTime=" + createTime +
                '}';
    }
}

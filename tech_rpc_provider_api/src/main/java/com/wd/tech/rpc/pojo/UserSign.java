package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 用户签到
 * @author: Lzy
 * @create: 2018-08-30 14:18
 **/
public class UserSign implements Serializable {

    private int id;

    private int userId;

    private Date signTime;
    //连续签到天数
    private int continuousSign;

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

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public int getContinuousSign() {
        return continuousSign;
    }

    public void setContinuousSign(int continuousSign) {
        this.continuousSign = continuousSign;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserSign{" +
                "id=" + id +
                ", userId=" + userId +
                ", signTime=" + signTime +
                ", continuousSign=" + continuousSign +
                ", createTime=" + createTime +
                '}';
    }
}

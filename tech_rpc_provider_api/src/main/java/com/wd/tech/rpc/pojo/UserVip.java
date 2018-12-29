package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/7.
 */
public class UserVip implements Serializable {

    private static final long serialVersionUID = -3666587834665755195L;

    public static int VIP_YES = 1;
    public static int VIP_NO = 2;

    private int id;
    private int userId;
    private Date expire;
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

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserVip{" +
                "id=" + id +
                ", userId=" + userId +
                ", expire=" + expire +
                ", createTime=" + createTime +
                '}';
    }

}

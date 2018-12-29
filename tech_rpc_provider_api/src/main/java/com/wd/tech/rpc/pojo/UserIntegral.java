package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 用户积分
 * @author: Lzy
 * @create: 2018-08-30 11:52
 **/
public class UserIntegral implements Serializable{

    /**
     *  收入
     */
    public final static int DIRECTION_SR = 1;

    /**
     *  支出
     */
    public final static int DIRECTION_ZC = 2;

    public final static int TYPE_QD = 1;
    public final static int TYPE_PL = 2;
    public final static int TYPE_FX = 3;
    public final static int TYPE_FT = 4;
    public final static int TYPE_CJSR = 5;
    public final static int TYPE_FFZX = 6;
    public final static int TYPE_CJZC = 7;
    public final static int TYPE_WSXX = 8;
    public final static int TYPE_CKGG = 9;
    public final static int TYPE_BDWX = 10;

    private int id;

    private int userId;
    //用户积分额度
    private int amount;

    private Date updateTime;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserIntegral{" +
                "id=" + id +
                ", userId=" + userId +
                ", amount=" + amount +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}

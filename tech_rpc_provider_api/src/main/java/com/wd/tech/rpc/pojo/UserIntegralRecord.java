package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 用户积分明细记录
 * @author: Lzy
 * @create: 2018-08-30 12:01
 **/
public class UserIntegralRecord implements Serializable{

     private int id;

     private int userId;
     //1为收入，2为支出
     private int direction;
     //积分类型（1=签到  2=评论  3=分享 4=发帖  5=抽奖收入  6=付费资讯  7=抽奖支出）
     private int type;
     //积分余额
     private int balance;
     //明细，收入支出具体金额
     private int detail;
     //备注信息
     private String remark;

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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getDetail() {
        return detail;
    }

    public void setDetail(int detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "UserIntegralRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", direction=" + direction +
                ", type=" + type +
                ", balance=" + balance +
                ", detail=" + detail +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

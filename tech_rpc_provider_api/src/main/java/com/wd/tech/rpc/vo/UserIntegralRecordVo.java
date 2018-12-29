package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/10/11.
 */
public class UserIntegralRecordVo implements Serializable {

    private static final long serialVersionUID = -2930030723311474709L;

    //1为收入，2为支出
    private int direction;
    //积分类型（1=签到  2=评论  3=分享 4=发帖  5=抽奖收入  6=付费资讯  7=抽奖支出）
    private int type;
    //明细，收入支出具体金额
    private int amount;
    private Date createTime;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserIntegralRecordVo{" +
                "direction=" + direction +
                ", type=" + type +
                ", amount=" + amount +
                ", createTime=" + createTime +
                '}';
    }
}

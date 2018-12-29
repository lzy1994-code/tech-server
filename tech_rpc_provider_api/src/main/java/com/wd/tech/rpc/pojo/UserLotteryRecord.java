package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/28.
 */
public class UserLotteryRecord implements Serializable {

    private static final long serialVersionUID = -5336119315058791134L;

    /**
     *  待领取
     */
    public final static int STATUS_DLQ = 1;

    /**
     *  已领取
     */
    public final static int STATUS_YLQ = 1;

    private int id;
    private int userId;
    private int prizeId;
    private int prizeValue;
    private String prizeName;
    private int status;
    private Date lotteryTime;
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

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLotteryTime() {
        return lotteryTime;
    }

    public void setLotteryTime(Date lotteryTime) {
        this.lotteryTime = lotteryTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(int prizeId) {
        this.prizeId = prizeId;
    }

    public int getPrizeValue() {
        return prizeValue;
    }

    public void setPrizeValue(int prizeValue) {
        this.prizeValue = prizeValue;
    }

    @Override
    public String toString() {
        return "UserLotteryRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", prizeId=" + prizeId +
                ", prizeValue=" + prizeValue +
                ", prizeName='" + prizeName + '\'' +
                ", status=" + status +
                ", lotteryTime=" + lotteryTime +
                ", createTime=" + createTime +
                '}';
    }
}

package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/25.
 */
public class UserVipRecord implements Serializable {

    private static final long serialVersionUID = -8842724811499249990L;

    /**
     *  未支付
     */
    public final static int PAY_STATUS_NO = 1;

    /**
     *  待支付
     */
    public final static int PAY_STATUS_YES = 2;

    private int id;
    private int userId;
    private String orderId;
    private int commodityId;
    private Date beforePurchase;
    private Date afterPurchase;
    private Date buyTime;
    private String remark;
    private double money;
    private int status;
    private Date payTime;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public Date getBeforePurchase() {
        return beforePurchase;
    }

    public void setBeforePurchase(Date beforePurchase) {
        this.beforePurchase = beforePurchase;
    }

    public Date getAfterPurchase() {
        return afterPurchase;
    }

    public void setAfterPurchase(Date afterPurchase) {
        this.afterPurchase = afterPurchase;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @Override
    public String toString() {
        return "UserVipRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderId='" + orderId + '\'' +
                ", commodityId=" + commodityId +
                ", beforePurchase=" + beforePurchase +
                ", afterPurchase=" + afterPurchase +
                ", buyTime=" + buyTime +
                ", remark='" + remark + '\'' +
                ", money=" + money +
                ", status=" + status +
                ", payTime=" + payTime +
                ", createTime=" + createTime +
                '}';
    }
}

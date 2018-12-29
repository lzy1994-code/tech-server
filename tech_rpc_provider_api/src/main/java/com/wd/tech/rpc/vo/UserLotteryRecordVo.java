package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/28.
 */
public class UserLotteryRecordVo implements Serializable {

    private static final long serialVersionUID = -5727414602245923376L;

    private int recordId;
    private int prizeValue;
    private String prizeName;
    private int status;
    private Date lotteryTime;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getPrizeValue() {
        return prizeValue;
    }

    public void setPrizeValue(int prizeValue) {
        this.prizeValue = prizeValue;
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
}

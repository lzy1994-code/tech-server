package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/9/28.
 */
public class PrizeVo implements Serializable {

    private static final long serialVersionUID = 376567388984172167L;

    private int prizeId;
    private String prizeName;
    private String prizePic;

    public int getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(int prizeId) {
        this.prizeId = prizeId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizePic() {
        return prizePic;
    }

    public void setPrizePic(String prizePic) {
        this.prizePic = prizePic;
    }

    @Override
    public String toString() {
        return "PrizeVo{" +
                "prizeId=" + prizeId +
                ", prizeName='" + prizeName + '\'' +
                ", prizePic='" + prizePic + '\'' +
                '}';
    }
}

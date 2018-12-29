package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/9/28.
 */
public class WinningVo implements Serializable {
    private static final long serialVersionUID = 7112874195851376183L;

    private String status;
    private String message;

    private int prizeId;
    private String prizeName;
    private String prizePic;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
        return "WinningVo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", prizeId=" + prizeId +
                ", prizeName='" + prizeName + '\'' +
                ", prizePic='" + prizePic + '\'' +
                '}';
    }
}

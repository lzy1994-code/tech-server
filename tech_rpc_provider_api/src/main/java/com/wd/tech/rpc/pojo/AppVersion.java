package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/7/18.
 */
public class AppVersion implements Serializable {

    private static final long serialVersionUID = 7360748467213111278L;

    private int id;
    private String ak;
    private String content;
    private String downloadUrl;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "AppVersion{" +
                "id=" + id +
                ", ak='" + ak + '\'' +
                ", content='" + content + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

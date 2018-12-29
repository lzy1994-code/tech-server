package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 用户资讯收藏
 * @author: Lzy
 * @create: 2018-08-29 08:56
 **/
public class UserInfoCollection implements Serializable {

    public static int WHETHER_COLLECTION_YES = 1;
    public static int WHETHER_COLLECTION_NO = 2;

    private int id;

    private int infoId;

    private String title;

    private String thumbnail;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserInfoCollection{" +
                "id=" + id +
                ", infoId=" + infoId +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

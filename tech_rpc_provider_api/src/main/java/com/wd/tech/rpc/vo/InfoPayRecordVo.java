package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 用户资讯支付vo
 * @author: Lzy
 * @create: 2018-09-04 14:04
 **/
public class InfoPayRecordVo implements Serializable{
    private int id;
    //标题
    private String title;
    //列表缩略图
    private String thumbnail;
    //来源
    private String source;
    //用户id
    private int userId;
    //资讯id
    private int infoId;
    //支付时间
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "InfoPayRecordVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", source='" + source + '\'' +
                ", userId=" + userId +
                ", infoId=" + infoId +
                ", createTime=" + createTime +
                '}';
    }
}

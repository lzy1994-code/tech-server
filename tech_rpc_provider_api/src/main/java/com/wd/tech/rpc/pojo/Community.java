package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 社区
 * @author: Lzy
 * @create: 2018-09-05 10:20
 **/
public class Community implements Serializable {
   //社区id
    private int id;
    //用户id
    private int userId;
    //内容
    private String content;
    //视频或图片（多图时，逗号间隔）
    private String file;
    //发表时间
    private Date publishTime;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", file='" + file + '\'' +
                ", publishTime=" + publishTime +
                '}';
    }
}

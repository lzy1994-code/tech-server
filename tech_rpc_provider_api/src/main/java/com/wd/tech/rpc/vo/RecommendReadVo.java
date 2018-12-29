package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * @program: tech-rpc
 * @description: 推荐阅读
 * @author: Lzy
 * @create: 2018-08-30 15:13
 **/
public class RecommendReadVo implements Serializable {
    private int id;

    private String title;
    //缩略图
    private String thumbnail;

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

    @Override
    public String toString() {
        return "RecommendReadVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}

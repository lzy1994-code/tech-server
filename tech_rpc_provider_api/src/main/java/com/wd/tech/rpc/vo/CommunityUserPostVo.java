package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * @program: tech-rpc
 * @description: 用户社区帖子列表vo区分于我的帖子
 * @author: Lzy
 * @create: 2018-10-22 15:56
 **/
public class CommunityUserPostVo  implements Serializable{
    private int id;
    //内容
    private String content;
    //视频或 图片地址
    private String file;
    //评论数
    private int comment;
    //点赞数
    private int praise;
    //当前登录用户是否点赞(2为否，1为是)
    private int whetherGreat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getWhetherGreat() {
        return whetherGreat;
    }

    public void setWhetherGreat(int whetherGreat) {
        this.whetherGreat = whetherGreat;
    }

    @Override
    public String toString() {
        return "CommunityUserPostVo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", file='" + file + '\'' +
                ", comment=" + comment +
                ", praise=" + praise +
                ", whetherGreat=" + whetherGreat +
                '}';
    }
}

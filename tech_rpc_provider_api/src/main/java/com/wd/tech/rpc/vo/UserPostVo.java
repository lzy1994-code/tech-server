package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 用户发布的帖子
 * @author: Lzy
 * @create: 2018-09-22 09:37
 **/
public class UserPostVo implements Serializable{

    //社区id
    private int id;
    //用户id
    private int userId;
    //用户头像
    private String headPic;
    //用户昵称
    private String nickName;
    //用户个性签名
    private String signature;
    //内容
    private String content;
    //视频或 图片地址
    private String file;
    //发表时间
    private Date publishTime;
    //评论数
    private int comment;
    //点赞数
    private int praise;


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

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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

    @Override
    public String toString() {
        return "UserPostVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", headPic='" + headPic + '\'' +
                ", nickName='" + nickName + '\'' +
                ", signature='" + signature + '\'' +
                ", content='" + content + '\'' +
                ", file='" + file + '\'' +
                ", publishTime=" + publishTime +
                ", comment=" + comment +
                ", praise=" + praise +
                '}';
    }
}

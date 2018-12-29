package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 社区vo
 * @author: Lzy
 * @create: 2018-09-06 13:55
 **/
public class CommunityVo implements Serializable {
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
    //是否为vip
    private int whetherVip;
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
    //当前登录用户是否关注作者(2为否，1为是)
    private int whetherFollow;
    //当前登录用户是否点赞(2为否，1为是)
    private int whetherGreat;
    /*//权限（用于判断当前用户是否有对此帖子进行修改删除等的权限 1=是，2=否）
    private int power;*/
    //附带最新三条评论
    private List<CommunityCommentVo> communityCommentVoList;
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

    public int getWhetherVip() {
        return whetherVip;
    }

    public void setWhetherVip(int whetherVip) {
        this.whetherVip = whetherVip;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getWhetherFollow() {
        return whetherFollow;
    }

    public void setWhetherFollow(int whetherFollow) {
        this.whetherFollow = whetherFollow;
    }

    public int getWhetherGreat() {
        return whetherGreat;
    }

    public void setWhetherGreat(int whetherGreat) {
        this.whetherGreat = whetherGreat;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<CommunityCommentVo> getCommunityCommentVoList() {
        return communityCommentVoList;
    }

    public void setCommunityCommentVoList(List<CommunityCommentVo> communityCommentVoList) {
        this.communityCommentVoList = communityCommentVoList;
    }

    @Override
    public String
    toString() {
        return "CommunityVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", headPic='" + headPic + '\'' +
                ", nickName='" + nickName + '\'' +
                ", signature='" + signature + '\'' +
                ", whetherVip=" + whetherVip +
                ", content='" + content + '\'' +
                ", file='" + file + '\'' +
                ", publishTime=" + publishTime +
                ", comment=" + comment +
                ", praise=" + praise +
                ", whetherFollow=" + whetherFollow +
                ", whetherGreat=" + whetherGreat +
                ", communityCommentVoList=" + communityCommentVoList +
                '}';
    }
}

package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/9/6.
 */
public class GroupListVo implements Serializable {

    private static final long serialVersionUID = 3540477243011896084L;

    private int groupId;
    private String groupName;
    private String groupImage;
    private String hxGroupId;
    //是否为黑名单小组
    private int blackFlag;
    //新加当前用户在群里的权限 1=普通用户  2=群管理   3=创建人
    private int role;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupImage() {
        return groupImage;
    }

    public void setGroupImage(String groupImage) {
        this.groupImage = groupImage;
    }

    public String getHxGroupId() {
        return hxGroupId;
    }

    public void setHxGroupId(String hxGroupId) {
        this.hxGroupId = hxGroupId;
    }

    public int getBlackFlag() {
        return blackFlag;
    }

    public void setBlackFlag(int blackFlag) {
        this.blackFlag = blackFlag;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "GroupListVo{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupImage='" + groupImage + '\'' +
                ", hxGroupId='" + hxGroupId + '\'' +
                ", blackFlag=" + blackFlag +
                ", role=" + role +
                '}';
    }
}

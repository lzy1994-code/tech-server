package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/9/6.
 */
public class GroupInfoVo implements Serializable {

    private static final long serialVersionUID = -1037516375335045236L;

    private int groupId;
    private String groupName;
    private String groupImage;
    private String hxGroupId;
    private String description;
    private int maxCount;
    private int currentCount;
    private int ownerUid;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getOwnerUid() {
        return ownerUid;
    }

    public void setOwnerUid(int ownerUid) {
        this.ownerUid = ownerUid;
    }

    @Override
    public String toString() {
        return "GroupInfoVo{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupImage='" + groupImage + '\'' +
                ", hxGroupId='" + hxGroupId + '\'' +
                ", description='" + description + '\'' +
                ", maxCount=" + maxCount +
                ", currentCount=" + currentCount +
                ", ownerUid=" + ownerUid +
                '}';
    }

}

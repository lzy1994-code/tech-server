package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/9/6.
 */
public class FriendGroupListVo implements Serializable {

    private static final long serialVersionUID = -3895487116474608382L;

    private int groupId;
    private String groupName;
    private int currentNumber;
    //是否为自定义分组  非自定义分组的不可以删除
    private int customize;
    //是否为黑名单分组  1=普通组  2=黑名单小组
    private int black;

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

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public int getCustomize() {
        return customize;
    }

    public void setCustomize(int customize) {
        this.customize = customize;
    }

    public int getBlack() {
        return black;
    }

    public void setBlack(int black) {
        this.black = black;
    }

    @Override
    public String toString() {
        return "FriendGroupListVo{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", currentNumber=" + currentNumber +
                ", customize=" + customize +
                ", black=" + black +
                '}';
    }
}

package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/1.
 */
public class FriendGroup implements Serializable{

    private static final long serialVersionUID = 4808306846000368380L;

    public static String MY_FRIEND = "我的好友";

    public static String MY_BLACK = "黑名单";

    /**
     *  非自定义分组
     */
    public static int CUSTOMIZE_1 = 1;

    /**
     *  自定义分组
     */
    public static int CUSTOMIZE_2 = 2;

    /**
     *  非黑名单
     */
    public static int BLACK_1 = 1;

    /**
     *  黑名单分组
     */
    public static int BLACK_2 = 2;

    private int id;
    private int userId;
    private String name;
    private int currentNumber;
    private int customize;
    private int black;
    private Date createTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        return "FriendGroup{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", currentNumber=" + currentNumber +
                ", customize=" + customize +
                ", black=" + black +
                ", createTime=" + createTime +
                '}';
    }
}

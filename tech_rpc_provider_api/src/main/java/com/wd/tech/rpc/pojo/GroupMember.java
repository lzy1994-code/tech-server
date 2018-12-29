package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/4.
 */
public class GroupMember implements Serializable {

    private static final long serialVersionUID = -7150296370871655773L;

    /**
     *  普通用户
     */
    public static int ROLE_USER = 1;

    /**
     * 群管理员
     */
    public static int ROLE_MANAGER = 2;

    /**
     * 群创建人
     */
    public static int ROLE_FOUNDER = 3;

    private int id;
    private int groupId;
    private int userId;
    private int role;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GroupMember{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", userId=" + userId +
                ", role=" + role +
                ", createTime=" + createTime +
                '}';
    }
}

package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/21.
 */
public class UserTaskRecord implements Serializable {

    private static final long serialVersionUID = 4537030006661202990L;

    private int id;
    private int taskId;
    private int userId;
    private Date taskTime;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(Date taskTime) {
        this.taskTime = taskTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserTaskRecord{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", userId=" + userId +
                ", taskTime=" + taskTime +
                ", createTime=" + createTime +
                '}';
    }

}

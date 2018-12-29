package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/9/21.
 */
public class UserTaskListVo implements Serializable {

    private static final long serialVersionUID = 8476644322322773612L;

    private int taskId;
    private String taskName;
    private int taskType;
    private int taskIntegral;
    private int status;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public int getTaskIntegral() {
        return taskIntegral;
    }

    public void setTaskIntegral(int taskIntegral) {
        this.taskIntegral = taskIntegral;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserTaskListVo{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskType=" + taskType +
                ", taskIntegral=" + taskIntegral +
                ", status=" + status +
                '}';
    }
}

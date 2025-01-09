package com.project.tms.response;

import com.project.tms.entity.TaskEntity;
import com.project.tms.object.Task;

public class TaskResponse {

    private String code;
    private String status;
    private String message;
    private Task task;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

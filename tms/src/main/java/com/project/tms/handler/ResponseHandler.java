package com.project.tms.handler;

import com.project.tms.entity.TaskEntity;
import com.project.tms.object.Task;
import com.project.tms.response.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class ResponseHandler {

    private TaskResponse taskResponse;

    public TaskResponse taskResponse(String code, String status, String message, Task task){
        taskResponse.setCode(code);
        taskResponse.setStatus(status);
        taskResponse.setMessage(message);
        taskResponse.setTask(task);

        return taskResponse;
    }

}

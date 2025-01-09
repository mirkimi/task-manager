package com.project.tms.controller;

import com.project.tms.constants.Message;
import com.project.tms.enums.StatusEnum;
import com.project.tms.handler.ResponseHandler;
import com.project.tms.object.Task;
import com.project.tms.request.TaskRequest;
import com.project.tms.response.TaskResponse;
import com.project.tms.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class ActivityController extends ResponseHandler {

    @Autowired
    private ActivityService activityService;

//    @GetMapping
//    public List<TaskEntity> getAllTasks(){
//        return taskService.findAll();
//    }

    @PostMapping("/getTaskById")
    public TaskResponse getTaskById(@RequestBody TaskRequest taskRequest) throws Exception{
        try{
            Task task = activityService.getTaskById(taskRequest.getId());

            if(task == null) {
                return taskResponse(StatusEnum.SUCCESS.code, StatusEnum.SUCCESS.status, Message.TASK_NOT_FOUND, null);
            }

            return taskResponse(StatusEnum.SUCCESS.code, StatusEnum.SUCCESS.status, Message.TASK_FOUND, task);

        }catch(Exception e){
            return taskResponse(StatusEnum.FAILED.code, StatusEnum.FAILED.status, Message.EXCEPTION_ENCOUNTERED, null);
        }
    }
}

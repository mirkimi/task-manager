package com.project.tms.controller;

import com.project.tms.constant.MessageConst;
import com.project.tms.enums.StatusEnum;
import com.project.tms.handler.ResponseHandler;
import com.project.tms.request.TaskRequest;
import com.project.tms.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/tasks")
public class ActivityController extends ResponseHandler {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/getAllTasks")
    public ResponseEntity<Object> getAllTasks(){
        HashMap<String, Object> response = new HashMap<>();
        try{
            response = activityService.getAllTasks();
            return ResponseHandler.responseSuccess(StatusEnum.SUCCESS.code, StatusEnum.SUCCESS.status, response);

        }catch(Exception e){
            return ResponseHandler.responseError(StatusEnum.FAILED.code, StatusEnum.FAILED.status, MessageConst.EXCEPTION_ENCOUNTERED);
        }
    }

    @GetMapping("/getTasks")
    public ResponseEntity<Object> getAllTasks(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        HashMap<String, Object> response = new HashMap<>();
        try{
            response = activityService.getAllTasks(page, size);
            return ResponseHandler.responseSuccess(StatusEnum.SUCCESS.code, StatusEnum.SUCCESS.status, response);

        }catch(Exception e){
            return ResponseHandler.responseError(StatusEnum.FAILED.code, StatusEnum.FAILED.status, MessageConst.EXCEPTION_ENCOUNTERED);
        }
    }

    @PostMapping("/getTaskById")
    public ResponseEntity<Object> getTaskById(@RequestBody TaskRequest taskRequest) throws Exception{
        HashMap<String, Object> response = new HashMap<>();
        try{
            response = activityService.getTaskById(taskRequest.getId());

            return ResponseHandler.responseSuccess(StatusEnum.SUCCESS.code, StatusEnum.SUCCESS.status, response);

        }catch(Exception e){

            return ResponseHandler.responseError(StatusEnum.FAILED.code, StatusEnum.FAILED.status, MessageConst.EXCEPTION_ENCOUNTERED);
        }
    }

    @PostMapping("/saveTask")
    public ResponseEntity<Object> saveTask(@RequestBody TaskRequest taskRequest) throws Exception{
        HashMap<String, Object> response = new HashMap<>();
        try{
            response = activityService.saveTask(taskRequest);

            return ResponseHandler.responseSuccess(StatusEnum.SUCCESS.code, StatusEnum.SUCCESS.status, response);

        }catch(Exception e){

            return ResponseHandler.responseError(StatusEnum.FAILED.code, StatusEnum.FAILED.status, MessageConst.EXCEPTION_ENCOUNTERED);
        }
    }

    @PatchMapping("/updateTask")
    public ResponseEntity<Object> updateTask(@RequestBody TaskRequest taskRequest) throws Exception{
        HashMap<String, Object> response = new HashMap<>();
        try{
            response = activityService.updateTask(taskRequest);

            return ResponseHandler.responseSuccess(StatusEnum.SUCCESS.code, StatusEnum.SUCCESS.status, response);

        }catch(Exception e){

            return ResponseHandler.responseError(StatusEnum.FAILED.code, StatusEnum.FAILED.status, MessageConst.EXCEPTION_ENCOUNTERED);
        }
    }

    @DeleteMapping("/deleteTask")
    public ResponseEntity<Object> deleteTask(@RequestBody TaskRequest taskRequest) throws Exception{
        HashMap<String, Object> response = new HashMap<>();
        try{
            response = activityService.deleteTask(taskRequest);

            return ResponseHandler.responseSuccess(StatusEnum.SUCCESS.code, StatusEnum.SUCCESS.status, response);

        }catch(Exception e){

            return ResponseHandler.responseError(StatusEnum.FAILED.code, StatusEnum.FAILED.status, MessageConst.EXCEPTION_ENCOUNTERED);
        }
    }
}

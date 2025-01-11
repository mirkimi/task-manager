package com.project.tms.service;

import com.project.tms.constant.MessageConst;
import com.project.tms.constant.ResConst;
import com.project.tms.entity.TaskEntity;
import com.project.tms.enums.TaskStatusEnum;
import com.project.tms.object.Task;
import com.project.tms.request.TaskRequest;
import com.project.tms.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivityService extends BaseService{

    @Autowired
    private TaskService taskService;

    public HashMap<String, Object> getAllTasks(){
        HashMap<String, Object> response = new HashMap<>();

        List<TaskEntity> allTasks = taskService.findAll();
        response.put(ResConst.TASKS, allTasks.stream()
                .map(taskEntity -> taskMapper.entityToObject(taskEntity))
                .collect(Collectors.toList()));
        response.put(ResConst.MESSAGE, MessageConst.ALL_TASK_RETRIEVED);

        return response;
    }

    public HashMap<String, Object> getAllTasks(int page, int size){
        HashMap<String, Object> response = new HashMap<>();

        Page<TaskEntity> allTasks = taskService.getAllTasks(page, size);
        response.put(ResConst.TASKS, mapTaskEntityList(allTasks.getContent()));
        response.put(ResConst.MESSAGE, MessageConst.ALL_TASK_RETRIEVED);
        response.put(ResConst.METADATA, mapMetadata(allTasks));

        return response;
    }

    public HashMap<String, Object> getTaskById(Long id) throws Exception{
        HashMap<String, Object> response = new HashMap<>();

        Optional<TaskEntity> task = taskService.findById(id);

        if(task.isPresent()){
            response.put(ResConst.TASK, taskMapper.entityToObject(task.get()));
            response.put(ResConst.MESSAGE, MessageConst.TASK_FOUND);
        }else{
            response.put(ResConst.TASK, null);
            response.put(ResConst.MESSAGE, MessageConst.TASK_NOT_FOUND);
        }

        return response;
    }

    public HashMap<String, Object> saveTask(TaskRequest taskRequest){
        HashMap<String, Object> response = new HashMap<>();

        TaskEntity taskEntity = taskMapper.requestToEntity(taskRequest);
        taskService.save(taskEntity);

        response.put(ResConst.MESSAGE, MessageConst.TASK_SAVED_SUCCESSFULLY);

        return response;
    }

    public HashMap<String, Object> updateTask(TaskRequest taskRequest){
        HashMap<String, Object> response = new HashMap<>();

        TaskEntity taskEntity = taskMapper.requestToEntity(taskRequest);
        if(taskService.update(taskEntity)){
            response.put(ResConst.MESSAGE, MessageConst.TASK_UPDATED_SUCCESSFULLY);
            return response;
        }

        response.put(ResConst.MESSAGE, MessageConst.TASK_UPDATE_UNSUCCESSFUL);

        return response;
    }

    public HashMap<String, Object> deleteTask(TaskRequest taskRequest){
        HashMap<String, Object> response = new HashMap<>();

        if(taskService.deleteById(taskRequest.getId())){
            response.put(ResConst.MESSAGE, MessageConst.TASK_DELETED_SUCCESSFULLY);
            return response;
        }
        response.put(ResConst.MESSAGE, MessageConst.TASK_DELETE_UNSUCCESSFUL);

        return response;
    }

    private HashMap<String, Object> mapMetadata(Page<TaskEntity> taskEntityPage){
        HashMap<String, Object> metadata = new HashMap<>();

        metadata.put(ResConst.CURRENT_PAGE, taskEntityPage.getNumber());
        metadata.put(ResConst.TOTAL_ITEMS, taskEntityPage.getTotalElements());
        metadata.put(ResConst.TOTAL_PAGE, taskEntityPage.getTotalPages());
        metadata.put(ResConst.PAGE_SIZE, taskEntityPage.getSize());
        metadata.put(ResConst.IS_LAST_PAGE, taskEntityPage.isLast());

        return metadata;
    }

    private List<Task> mapTaskEntityList(List<TaskEntity> taskEntities){
        return taskEntities.stream()
                .map(taskEntity -> {
                    return taskMapper.entityToObject(taskEntity);
                })
                .collect(Collectors.toList());
    }
}

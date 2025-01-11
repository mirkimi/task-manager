package com.project.tms.mapper;

import com.project.tms.entity.TaskEntity;
import com.project.tms.enums.TaskStatusEnum;
import com.project.tms.object.Task;
import com.project.tms.request.TaskRequest;
import com.project.tms.util.DateTimeUtil;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task entityToObject(TaskEntity taskEntity){
        Task task = new Task();
        task.setId(taskEntity.getId());
        task.setTitle(taskEntity.getTitle());
        task.setDescription(taskEntity.getDescription());
        task.setStatus(TaskStatusEnum.getDisplayNameFromCode(taskEntity.getStatus()));
        task.setStartDate(DateTimeUtil.convertDBToString(taskEntity.getStartDate()));
        task.setEndDate(DateTimeUtil.convertDBToString(taskEntity.getEndDate()));
        return task;
    }

    public TaskEntity updateRequestToEntityMapper(TaskEntity oldTaskEntity, TaskEntity newTaskEntity){
        if (newTaskEntity.getDescription() != null) {
            oldTaskEntity.setDescription(newTaskEntity.getDescription());
        }
        if (newTaskEntity.getTitle() != null) {
            oldTaskEntity.setTitle(newTaskEntity.getTitle());
        }
        if (newTaskEntity.getStatus() != null) {
            oldTaskEntity.setStatus(newTaskEntity.getStatus());
        }
        if (newTaskEntity.getStartDate() != null) {
            oldTaskEntity.setStartDate(newTaskEntity.getStartDate());
        }
        if (newTaskEntity.getEndDate() != null) {
            oldTaskEntity.setEndDate(newTaskEntity.getEndDate());
        }

        return oldTaskEntity;
    }

    public TaskEntity requestToEntity(TaskRequest taskRequest){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(taskRequest.getId());
        taskEntity.setTitle(taskRequest.getTitle());
        taskEntity.setDescription(taskRequest.getDescription());
        taskEntity.setStatus(TaskStatusEnum.getCodeFromRequest(taskRequest.getStatus()));
        taskEntity.setStartDate(DateTimeUtil.convertDateTimeToDB(taskRequest.getStartDate()));
        taskEntity.setEndDate(DateTimeUtil.convertDateTimeToDB(taskRequest.getEndDate()));

        return taskEntity;
    }
}

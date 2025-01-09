package com.project.tms.mapper;

import com.project.tms.entity.TaskEntity;
import com.project.tms.object.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task entityToObject(TaskEntity taskEntity){
        Task task = new Task();
        task.setId(taskEntity.getId());
        task.setTitle(taskEntity.getTitle());
        task.setDescription(taskEntity.getDescription());
        task.setDueDate(taskEntity.getDueDate());
        task.setStatus(taskEntity.getStatus());
        return task;
    }
}

package com.project.tms.service;

import com.project.tms.entity.TaskEntity;
import com.project.tms.mapper.TaskMapper;
import com.project.tms.object.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskMapper taskMapper;

    public Task getTaskById(Long id) throws Exception{
        Optional<TaskEntity> task = taskService.findById(id);

        if(task.isPresent()){
            return taskMapper.entityToObject(task.get());
        }else{
            return new Task();
        }
    }
}

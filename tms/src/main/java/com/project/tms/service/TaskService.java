package com.project.tms.service;

import com.project.tms.entity.TaskEntity;
import com.project.tms.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskEntity> findAll(){
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> findById(Long id){
        return taskRepository.findById(id);
    }

    public TaskEntity save(TaskEntity taskEntity){
        return taskRepository.save(taskEntity);
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }
}

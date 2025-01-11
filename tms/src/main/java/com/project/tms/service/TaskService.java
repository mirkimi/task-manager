package com.project.tms.service;

import com.project.tms.constant.FieldConst;
import com.project.tms.entity.TaskEntity;
import com.project.tms.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService extends BaseService{

    @Autowired
    private TaskRepository taskRepository;


    @Transactional(readOnly = true)
    public List<TaskEntity> findAll(){
        return taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<TaskEntity> findById(Long id){
        return taskRepository.findById(id);
    }

    @Transactional
    public void save(TaskEntity taskEntity){
        taskRepository.save(taskEntity);
    }

    @Transactional
    public boolean update(TaskEntity taskEntity){
        Optional<TaskEntity> getTaskEntity = this.findById(taskEntity.getId());

        if(getTaskEntity.isEmpty()){
            logger.info("No task found for id {}", taskEntity.getId());
            return false;
        }

        TaskEntity oldTaskEntity = getTaskEntity.get();
        oldTaskEntity = taskMapper.updateRequestToEntityMapper(oldTaskEntity, taskEntity);
        this.save(oldTaskEntity);

        return true;
    }

    @Transactional
    public boolean deleteById(Long id){
        Optional<TaskEntity> getTaskEntity = this.findById(id);

        if(getTaskEntity.isEmpty()){
            logger.info("No task found for id {}", id);
            return false;
        }

        taskRepository.deleteById(id);

        return true;
    }

    @Transactional(readOnly = true)
    public Page<TaskEntity> getAllTasks(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(FieldConst.ID).ascending());
        return taskRepository.findAll(pageable);
    }
}

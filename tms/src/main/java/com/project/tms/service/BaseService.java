package com.project.tms.service;

import com.project.tms.mapper.TaskMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
    protected static final Logger logger = LogManager.getLogger(BaseService.class);
    protected TaskMapper taskMapper = new TaskMapper();
}

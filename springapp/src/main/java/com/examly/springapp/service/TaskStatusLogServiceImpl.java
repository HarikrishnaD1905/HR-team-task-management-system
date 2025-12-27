package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.repository.TaskStatusLogRepository;

@Service
public class TaskStatusLogServiceImpl implements TaskStatusLogService {

    @Autowired
    private TaskStatusLogRepository repository;

    public TaskStatusLog add(TaskStatusLog log) {
        return repository.save(log);
    }

    public List<TaskStatusLog> getAll() {
        return repository.findAll();
    }

    public TaskStatusLog getById(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Status log not found"));
    }
        
    public List<TaskStatusLog> getByTask(Long taskId) {
        return repository.findByTaskId(taskId);
    }

    public List<TaskStatusLog> getByOldStatus(String oldStatus) {
        return repository.findByOldStatus(oldStatus);
    }
}

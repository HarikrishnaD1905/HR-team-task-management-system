package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.TaskStatusLog;

public interface TaskStatusLogService {
    TaskStatusLog add(TaskStatusLog log);
    List<TaskStatusLog> getAll();
    TaskStatusLog getById(Long id);
    List<TaskStatusLog> getByTask(Long taskId);
    List<TaskStatusLog> getByOldStatus(String oldStatus);
}
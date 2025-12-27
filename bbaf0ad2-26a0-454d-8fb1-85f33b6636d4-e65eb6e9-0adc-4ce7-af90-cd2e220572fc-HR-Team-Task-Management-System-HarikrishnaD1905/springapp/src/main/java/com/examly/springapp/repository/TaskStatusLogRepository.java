package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;
import com.examly.springapp.model.TaskStatusLog;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

@Repository
public interface TaskStatusLogRepository extends JpaRepository<TaskStatusLog, Long> {
    List<TaskStatusLog> findByTaskId(Long taskId);
    List<TaskStatusLog> findByOldStatus(String oldStatus);
}

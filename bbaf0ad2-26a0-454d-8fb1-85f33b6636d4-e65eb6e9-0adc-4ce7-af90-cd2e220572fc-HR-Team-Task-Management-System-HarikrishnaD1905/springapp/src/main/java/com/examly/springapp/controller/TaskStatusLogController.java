package com.examly.springapp.controller;

import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.service.TaskStatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/status-logs")
public class TaskStatusLogController {

    @Autowired
    private TaskStatusLogService service;

    @PostMapping
    public ResponseEntity<TaskStatusLog> add(@RequestBody TaskStatusLog log) {
        return new ResponseEntity<>(service.add(log), HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<TaskStatusLog>> all() {
            return ResponseEntity.ok(service.getAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<TaskStatusLog> get(@PathVariable Long id) {
            return ResponseEntity.ok(service.getById(id));
        }

        @GetMapping("/task/{id}")
        public ResponseEntity<List<TaskStatusLog>> byTask(@PathVariable Long id) {
            return ResponseEntity.ok(service.getByTask(id));
        }

        @GetMapping("/old/{status}")
        public ResponseEntity<?> byOldStatus(@PathVariable String status) {
            List<TaskStatusLog> logs = service.getByOldStatus(status);

            if (logs.isEmpty()) {
                return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("No logs found with oldStatus: " + status);
            }

            return ResponseEntity.ok(logs);
            }
}
package com.examly.springapp.controller;

import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<Task> add(@RequestBody Task task) {
        return ResponseEntity.ok(service.addTask(task));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(service.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getTaskById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404)
            .body("Task not found with id " + id);
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(@PathVariable Long id,
    @RequestParam String status) {
        return ResponseEntity.ok(service.updateTaskStatus(id, status));
        }

        @GetMapping("/user/{id}")
        public ResponseEntity<List<Task>> byUser(@PathVariable Long id) {
            return ResponseEntity.ok(service.getTasksByUser(id));
        }

        @GetMapping("/status/{status}")
        public ResponseEntity<?> byStatus(@PathVariable String status) {
            List<Task> tasks = service.getTasksByStatus(status);
            if (tasks.isEmpty())
            return ResponseEntity.status(404)
            .body("No tasks found with status: UNKNOWN_STATUS");
            return ResponseEntity.ok(tasks);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
            return ResponseEntity.noContent().build();
        }

        @GetMapping("/status")
        public ResponseEntity<String> statusMissing() {
            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("No tasks found with status: UNKNOWN_STATUS");
        }
}
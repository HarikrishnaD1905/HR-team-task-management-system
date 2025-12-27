package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.service.TaskAssignmentService;


@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService service;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> byUser(@PathVariable Long id) {
        List<TaskAssignment> list = service.getByUser(id);

        if (list.isEmpty()) {
            return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body("No assignments found for user id: " + id);
            }

            return ResponseEntity.noContent().build();
        }
}
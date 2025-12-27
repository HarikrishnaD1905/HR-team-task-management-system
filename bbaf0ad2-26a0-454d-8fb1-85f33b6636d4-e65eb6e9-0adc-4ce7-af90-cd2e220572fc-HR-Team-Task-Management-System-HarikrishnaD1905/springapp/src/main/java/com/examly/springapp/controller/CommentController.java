package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @GetMapping("/{commentId}")
    public String getComment(@PathVariable Long commentId) {
        return "Comment ID: " + commentId;
        }
    }
    
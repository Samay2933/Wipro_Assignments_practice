package com.task.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import com.task.entity.Task;
import com.task.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<?> addTask(@Validated @RequestBody Task task) {
        return taskService.addTask(task);
    }

    @PutMapping
    public ResponseEntity<?> updateTask(@Validated @RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Integer id) {
        return taskService.deleteTask(id);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByStatus(@RequestParam(required = false) String status) {
        return taskService.searchByStatus(status);
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Task>> getByPriority(@PathVariable String priority) {
        return ResponseEntity.ok(taskService.getTasksByPriority(priority));
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<Task>> getOverdueTasks() {
        return ResponseEntity.ok(taskService.getOverdueTasks());
    }
}

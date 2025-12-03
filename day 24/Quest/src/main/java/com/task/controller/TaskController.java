package com.task.controller;

import com.task.model.Task;
import com.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        try {
            Task created = taskService.addTask(task);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (RuntimeException ex) {
            if (ex.getMessage().contains("exists")) return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateTask(@RequestBody Task task) {
        try {
            Task updated = taskService.updateTask(task);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            if (ex.getMessage().contains("does not exist")) return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.ok("Task deleted");
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByStatus(@RequestParam(required = false) String status) {
        if (status == null) return new ResponseEntity<>("Missing status", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(taskService.searchByStatus(status));
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Task>> getByPriority(@PathVariable Task.Priority priority) {
        return ResponseEntity.ok(taskService.byPriority(priority));
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<Task>> getOverdueTasks() {
        return ResponseEntity.ok(taskService.findOverdueTasks());
    }
}

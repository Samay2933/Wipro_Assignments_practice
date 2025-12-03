package com.task.service;

import com.task.dto.TaskDTO;
import com.task.entity.Task;
import com.task.entity.User;
import com.task.entity.Label;
import com.task.repository.TaskRepository;
import com.task.repository.UserRepository;
import com.task.repository.LabelRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LabelRepository labelRepository;

    public ResponseEntity<?> addTask(Task task) {
        if (taskRepository.existsById(task.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Task with same ID already exists.");
        }
        // Validate priority, status, dueDate here
        taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    public ResponseEntity<?> updateTask(Task task) {
        if (!taskRepository.existsById(task.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task does not exist.");
        }
        // Validations
        taskRepository.save(task);
        return ResponseEntity.ok(task);
    }

    public ResponseEntity<?> deleteTask(Integer id) {
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task does not exist.");
        }
        taskRepository.deleteById(id);
        return ResponseEntity.ok("Task deleted.");
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public ResponseEntity<?> searchByStatus(String status) {
        if (status == null || status.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList());
        }
        List<Task> tasks = taskRepository.findByStatusIgnoreCase(status);
        return ResponseEntity.ok(tasks);
    }

    public List<Task> getTasksByPriority(String priority) {
        return taskRepository.findByPriorityIgnoreCase(priority);
    }

    public List<Task> getOverdueTasks() {
        return taskRepository.findByDueDateBeforeAndStatusNot(LocalDate.now(), "completed");
    }
}

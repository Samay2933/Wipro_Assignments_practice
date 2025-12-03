package com.task.service;

import com.task.model.Task;
import com.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task addTask(Task task) {
        if (repository.existsById(task.getId())) {
            throw new RuntimeException("Task with same ID already exists");
        }
        // Add your field validations (priority, status, dueDate format)
        return repository.save(task);
    }

    public Task updateTask(Task task) {
        if (!repository.existsById(task.getId())) {
            throw new RuntimeException("Task does not exist");
        }
        return repository.save(task);
    }

    public void deleteTask(Long id) {
        if (!repository.existsById(id)) throw new RuntimeException("Task doesn't exist");
        repository.deleteById(id);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public List<Task> searchByStatus(String status) {
        return repository.findByStatusIgnoreCase(status);
    }

    public List<Task> byPriority(Task.Priority priority) {
        return repository.findByPriority(priority);
    }

    public List<Task> findOverdueTasks() {
        LocalDate today = LocalDate.now();
        return repository.findByDueDateBeforeAndStatusNot(today, Task.Status.COMPLETED);
    }
}

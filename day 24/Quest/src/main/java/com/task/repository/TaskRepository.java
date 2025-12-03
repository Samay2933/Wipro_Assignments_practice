package com.task.repository;

import com.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatusIgnoreCase(String status);
    List<Task> findByPriority(Task.Priority priority);
    List<Task> findByDueDateBeforeAndStatusNot(LocalDate today, Task.Status status);
}

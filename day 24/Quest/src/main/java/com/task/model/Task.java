package com.task.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Task {
    @Id
    private Long id;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate dueDate;

    public enum Priority { LOW, MEDIUM, HIGH }
    public enum Status { PENDING, IN_PROGRESS, COMPLETED }
}

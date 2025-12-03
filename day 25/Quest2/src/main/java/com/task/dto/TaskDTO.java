package com.task.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

public class TaskDTO {
    @NotNull
    private Integer id;

    @NotBlank
    private String title;

    private String description;

    @NotBlank
    private String assignedTo;

    @NotBlank
    @Pattern(regexp = "low|medium|high", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Priority must be one of: low, medium, high")
    private String priority;

    @NotBlank
    @Pattern(regexp = "pending|in-progress|completed", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Status must be one of: pending, in-progress, completed")
    private String status;

    @NotNull(message = "Due date is required")
    private LocalDate dueDate;

    private UserDTO user;

    private Set<LabelDTO> labels;

    // getters and setters ...
}

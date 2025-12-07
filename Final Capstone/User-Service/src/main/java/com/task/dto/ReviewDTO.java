package com.task.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ReviewDTO {
    private Long id;
    
    @NotNull(message = "User ID is required")
    private Long userId;
    
    @NotNull(message = "App ID is required")
    private Long appId;
    
    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Integer rating;
    
    @Size(max = 1000, message = "Comment cannot exceed 1000 characters")
    private String comment;
}
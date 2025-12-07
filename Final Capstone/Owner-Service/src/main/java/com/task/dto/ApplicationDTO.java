package com.task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ApplicationDTO {
    private Long id;
    
    @NotNull(message = "Owner ID is required")
    private Long ownerId;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    private String description;
    private String version;
    private String category;
    private Double rating;
    private String genre;
    private LocalDateTime releaseDate;
    private Boolean isVisible;
    private Long downloadCount;
}
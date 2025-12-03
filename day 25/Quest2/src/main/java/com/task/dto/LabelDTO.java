package com.task.dto;

import jakarta.validation.constraints.*;

public class LabelDTO {
    private Integer id;

    @NotBlank
    private String name;

    private String colorCode;

    // getters and setters ...
}

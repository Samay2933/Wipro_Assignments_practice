package com.task.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public class UserDTO {
    private Integer id;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Mobile must be exactly 10 digits")
    private String mobile;

    private ProfileDTO profile;

    private List<TaskDTO> tasks;

    // getters and setters ...
}

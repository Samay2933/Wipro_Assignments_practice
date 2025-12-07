package com.task.dto;

import lombok.Data;

@Data
public class AnnouncementDTO {
    private String subject;
    private String message;
    private Long appId;
}
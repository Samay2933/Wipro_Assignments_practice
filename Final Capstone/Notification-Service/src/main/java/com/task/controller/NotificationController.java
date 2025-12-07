package com.task.controller;

import com.task.model.NotificationRequest;
import com.task.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@Tag(name = "Notification Management", description = "APIs for sending notifications")
public class NotificationController {
    
    @Autowired
    private NotificationService notificationService;
    
    @PostMapping("/send")
    @Operation(summary = "Send email notification")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        String result = notificationService.sendEmail(request);
        return ResponseEntity.ok(result);
    }
}
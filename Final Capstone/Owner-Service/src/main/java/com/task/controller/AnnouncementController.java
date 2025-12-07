package com.task.controller;

import com.task.client.NotificationClient;
import com.task.dto.AnnouncementDTO;
import com.task.dto.NotificationRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/announcements")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnnouncementController {
    
    @Autowired(required = false)
    private NotificationClient notificationClient;
    
    @PostMapping("/send")
    @Operation(summary = "Send update announcement to users")
    public ResponseEntity<String> sendAnnouncement(@RequestBody AnnouncementDTO announcement) {
        try {
            if (notificationClient != null) {
                NotificationRequest notification = new NotificationRequest();
                notification.setRecipient("all-users@playstore.com");
                notification.setSubject(announcement.getSubject());
                notification.setMessage(announcement.getMessage());
                notificationClient.sendNotification(notification);
                return ResponseEntity.ok("Announcement sent successfully!");
            }
            return ResponseEntity.ok("Notification service unavailable");
        } catch (Exception e) {
            return ResponseEntity.ok("Announcement logged: " + announcement.getMessage());
        }
    }
}
package com.task.client;

import com.task.dto.NotificationRequest;
import org.springframework.stereotype.Component;

@Component
public class NotificationClientFallback implements NotificationClient {
    
    @Override
    public String sendNotification(NotificationRequest request) {
        System.out.println("Notification service unavailable. Notification not sent.");
        return "Notification service unavailable";
    }
}
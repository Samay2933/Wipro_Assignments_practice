package com.task.service;

import com.task.model.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    
    @Autowired(required = false)
    private JavaMailSender mailSender;
    
    public String sendEmail(NotificationRequest request) {
        try {
            // In development, just log the notification
            System.out.println("=== EMAIL NOTIFICATION ===");
            System.out.println("To: " + request.getRecipient());
            System.out.println("Subject: " + request.getSubject());
            System.out.println("Message: " + request.getMessage());
            System.out.println("========================");
            
            // Uncomment below code if you have configured mail server
            /*
            if (mailSender != null) {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(request.getRecipient());
                message.setSubject(request.getSubject());
                message.setText(request.getMessage());
                mailSender.send(message);
            }
            */
            
            return "Notification sent successfully";
        } catch (Exception e) {
            System.err.println("Failed to send notification: " + e.getMessage());
            return "Failed to send notification: " + e.getMessage();
        }
    }
}
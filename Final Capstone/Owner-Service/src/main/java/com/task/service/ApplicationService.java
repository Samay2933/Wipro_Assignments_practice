package com.task.service;

import com.task.client.NotificationClient;
import com.task.dto.ApplicationDTO;
import com.task.dto.NotificationRequest;
import com.task.exception.CustomException;
import com.task.model.Application;
import com.task.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApplicationService {
    
    @Autowired
    private ApplicationRepository applicationRepository;
    
    @Autowired(required = false)
    private NotificationClient notificationClient;
    
    public Application createApplication(ApplicationDTO dto) {
        Application app = new Application();
        app.setOwnerId(dto.getOwnerId());
        app.setName(dto.getName());
        app.setDescription(dto.getDescription());
        app.setVersion(dto.getVersion());
        app.setCategory(dto.getCategory());
        app.setRating(dto.getRating());
        app.setGenre(dto.getGenre());
        app.setReleaseDate(dto.getReleaseDate());
        app.setIsVisible(dto.getIsVisible() != null ? dto.getIsVisible() : true);
        
        Application savedApp = applicationRepository.save(app);
        
        // Send notification
        try {
            if (notificationClient != null) {
                NotificationRequest notification = new NotificationRequest();
                notification.setRecipient("users@playstore.com");
                notification.setSubject("New App: " + savedApp.getName());
                notification.setMessage("A new application '" + savedApp.getName() + "' has been added!");
                notificationClient.sendNotification(notification);
            }
        } catch (Exception e) {
            System.out.println("Failed to send notification: " + e.getMessage());
        }
        
        return savedApp;
    }
    
    public Application updateApplication(Long id, ApplicationDTO dto) {
        Application app = applicationRepository.findById(id)
            .orElseThrow(() -> new CustomException("Application not found"));
        
        app.setName(dto.getName());
        app.setDescription(dto.getDescription());
        app.setVersion(dto.getVersion());
        app.setCategory(dto.getCategory());
        app.setRating(dto.getRating());
        app.setGenre(dto.getGenre());
        app.setIsVisible(dto.getIsVisible());
        
        Application updatedApp = applicationRepository.save(app);
        
        // Send update notification
        try {
            if (notificationClient != null) {
                NotificationRequest notification = new NotificationRequest();
                notification.setRecipient("users@playstore.com");
                notification.setSubject("App Updated: " + updatedApp.getName());
                notification.setMessage("The application '" + updatedApp.getName() + "' has been updated!");
                notificationClient.sendNotification(notification);
            }
        } catch (Exception e) {
            System.out.println("Failed to send notification: " + e.getMessage());
        }
        
        return updatedApp;
    }
    
    public void deleteApplication(Long id) {
        if (!applicationRepository.existsById(id)) {
            throw new CustomException("Application not found");
        }
        applicationRepository.deleteById(id);
    }
    
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
            .orElseThrow(() -> new CustomException("Application not found"));
    }
    
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
    
    public List<Application> getApplicationsByOwner(Long ownerId) {
        return applicationRepository.findByOwnerId(ownerId);
    }
    
    public List<Application> searchByName(String name) {
        return applicationRepository.findByNameContainingIgnoreCase(name);
    }
    
    public List<Application> filterByCategory(String category) {
        return applicationRepository.findByCategory(category);
    }
    
    public List<Application> filterByRating(Double minRating) {
        return applicationRepository.findByRatingGreaterThanEqual(minRating);
    }
    
    public void updateVisibility(Long id, Boolean isVisible) {
        Application app = getApplicationById(id);
        app.setIsVisible(isVisible);
        applicationRepository.save(app);
    }
    
 // ADD THESE METHODS TO EXISTING ApplicationService.java

    public List<Application> getAllVisibleApplications() {
        return applicationRepository.findByIsVisible(true);
    }

    public List<Application> searchVisibleByName(String name) {
        return applicationRepository.findByIsVisibleAndNameContainingIgnoreCase(true, name);
    }

    public List<Application> filterVisibleByCategory(String category) {
        return applicationRepository.findByIsVisibleAndCategory(true, category);
    }

    public List<Application> filterVisibleByRating(Double minRating) {
        return applicationRepository.findByIsVisibleAndRatingGreaterThanEqual(true, minRating);
    }
    
    public void incrementDownloadCount(Long id) {
        Application app = getApplicationById(id);
        app.setDownloadCount(app.getDownloadCount() + 1);
        applicationRepository.save(app);
        
        // Send download notification to owner
        try {
            if (notificationClient != null) {
                NotificationRequest notification = new NotificationRequest();
                notification.setRecipient("owner@playstore.com");
                notification.setSubject("App Downloaded: " + app.getName());
                notification.setMessage("Your application '" + app.getName() + "' has been downloaded! Total downloads: " + app.getDownloadCount());
                notificationClient.sendNotification(notification);
            }
        } catch (Exception e) {
            System.out.println("Failed to send download notification: " + e.getMessage());
        }
    }
}
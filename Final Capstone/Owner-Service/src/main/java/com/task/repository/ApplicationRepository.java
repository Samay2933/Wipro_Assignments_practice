package com.task.repository;

import com.task.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByOwnerId(Long ownerId);
    List<Application> findByCategory(String category);
    List<Application> findByNameContainingIgnoreCase(String name);
    List<Application> findByIsVisible(Boolean isVisible);
    List<Application> findByRatingGreaterThanEqual(Double rating);
    
    // Filter by visibility
    List<Application> findByIsVisibleAndCategory(Boolean isVisible, String category);
    List<Application> findByIsVisibleAndNameContainingIgnoreCase(Boolean isVisible, String name);
    List<Application> findByIsVisibleAndRatingGreaterThanEqual(Boolean isVisible, Double rating);
}
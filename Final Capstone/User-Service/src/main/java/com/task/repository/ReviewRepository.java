package com.task.repository;

import com.task.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByAppId(Long appId);
    List<Review> findByUserId(Long userId);
    List<Review> findByAppIdAndRatingGreaterThanEqual(Long appId, Integer rating);
}
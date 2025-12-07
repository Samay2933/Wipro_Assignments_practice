package com.task.service;

import com.task.dto.ReviewDTO;
import com.task.exception.CustomException;
import com.task.model.Review;
import com.task.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;
    
    public Review createReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setUserId(reviewDTO.getUserId());
        review.setAppId(reviewDTO.getAppId());
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());
        
        return reviewRepository.save(review);
    }
    
    public List<Review> getReviewsByAppId(Long appId) {
        return reviewRepository.findByAppId(appId);
    }
    
    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
    
    public List<Review> getReviewsByAppIdAndRating(Long appId, Integer minRating) {
        return reviewRepository.findByAppIdAndRatingGreaterThanEqual(appId, minRating);
    }
    
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
    
    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new CustomException("Review not found with id: " + id);
        }
        reviewRepository.deleteById(id);
    }
    
    /*
     Create a review (save rating and comment for an app)

Get reviews by app ID

Get reviews by user ID

Get reviews by app ID with minimum rating

Get all reviews

Delete a review (throws error if review doesn’t exist)
     * */
}
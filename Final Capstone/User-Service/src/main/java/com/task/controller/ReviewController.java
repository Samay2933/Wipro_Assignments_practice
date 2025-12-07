package com.task.controller;

import com.task.dto.ReviewDTO;
import com.task.model.Review;
import com.task.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Review Management", description = "APIs for review operations")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewService;
    
    @PostMapping
    @Operation(summary = "Create a new review")
    public ResponseEntity<Review> createReview(@Valid @RequestBody ReviewDTO reviewDTO) {
        Review review = reviewService.createReview(reviewDTO);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }
    
    @GetMapping("/app/{appId}")
    @Operation(summary = "Get reviews by app ID")
    public ResponseEntity<List<Review>> getReviewsByAppId(@PathVariable Long appId) {
        List<Review> reviews = reviewService.getReviewsByAppId(appId);
        return ResponseEntity.ok(reviews);
    }
    
    @GetMapping("/user/{userId}")
    @Operation(summary = "Get reviews by user ID")
    public ResponseEntity<List<Review>> getReviewsByUserId(@PathVariable Long userId) {
        List<Review> reviews = reviewService.getReviewsByUserId(userId);
        return ResponseEntity.ok(reviews);
    }
    
    @GetMapping("/app/{appId}/rating/{minRating}")
    @Operation(summary = "Filter reviews by app and minimum rating")
    public ResponseEntity<List<Review>> getReviewsByRating(
            @PathVariable Long appId, 
            @PathVariable Integer minRating) {
        List<Review> reviews = reviewService.getReviewsByAppIdAndRating(appId, minRating);
        return ResponseEntity.ok(reviews);
    }
    
    @GetMapping
    @Operation(summary = "Get all reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete review")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok("Review deleted successfully");
    }
}
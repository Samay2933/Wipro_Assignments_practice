package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/owner/reviews")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReviewViewController {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/app/{appId}")
    public ResponseEntity<?> getReviewsForApp(@PathVariable Long appId) {
        String url = "http://user-service/api/reviews/app/" + appId;
        Object reviews = restTemplate.getForObject(url, Object.class);
        return ResponseEntity.ok(reviews);
    }
}
package com.task.controller;

import com.task.dto.ApplicationDTO;
import com.task.model.Application;
import com.task.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Application Management", description = "APIs for application CRUD operations")
public class ApplicationController {
    
    @Autowired
    private ApplicationService applicationService;
    
    @PostMapping
    @Operation(summary = "Create a new application")
    public ResponseEntity<Application> createApplication(@Valid @RequestBody ApplicationDTO dto) {
        Application app = applicationService.createApplication(dto);
        return new ResponseEntity<>(app, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update an application")
    public ResponseEntity<Application> updateApplication(
            @PathVariable Long id, 
            @Valid @RequestBody ApplicationDTO dto) {
        Application app = applicationService.updateApplication(id, dto);
        return ResponseEntity.ok(app);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an application")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.ok("Application deleted successfully");
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get application by ID")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        Application app = applicationService.getApplicationById(id);
        return ResponseEntity.ok(app);
    }
    
    @GetMapping
    @Operation(summary = "Get all applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> apps = applicationService.getAllApplications();
        return ResponseEntity.ok(apps);
    }
    
    @GetMapping("/owner/{ownerId}")
    @Operation(summary = "Get applications by owner ID")
    public ResponseEntity<List<Application>> getApplicationsByOwner(@PathVariable Long ownerId) {
        List<Application> apps = applicationService.getApplicationsByOwner(ownerId);
        return ResponseEntity.ok(apps);
    }
    
    @GetMapping("/search")
    @Operation(summary = "Search applications by name")
    public ResponseEntity<List<Application>> searchByName(@RequestParam String name) {
        List<Application> apps = applicationService.searchByName(name);
        return ResponseEntity.ok(apps);
    }
    
    @GetMapping("/category/{category}")
    @Operation(summary = "Filter applications by category")
    public ResponseEntity<List<Application>> filterByCategory(@PathVariable String category) {
        List<Application> apps = applicationService.filterByCategory(category);
        return ResponseEntity.ok(apps);
    }
    
    @GetMapping("/rating/{minRating}")
    @Operation(summary = "Filter applications by minimum rating")
    public ResponseEntity<List<Application>> filterByRating(@PathVariable Double minRating) {
        List<Application> apps = applicationService.filterByRating(minRating);
        return ResponseEntity.ok(apps);
    }
    
    @PatchMapping("/{id}/visibility")
    @Operation(summary = "Update application visibility")
    public ResponseEntity<String> updateVisibility(
            @PathVariable Long id, 
            @RequestParam Boolean isVisible) {
        applicationService.updateVisibility(id, isVisible);
        return ResponseEntity.ok("Visibility updated");
    }
    
    @PatchMapping("/{id}/download")
    @Operation(summary = "Increment download count")
    public ResponseEntity<String> incrementDownload(@PathVariable Long id) {
        applicationService.incrementDownloadCount(id);
        return ResponseEntity.ok("Download count updated");
    }
    
 // ADD THESE METHODS TO EXISTING ApplicationController.java

    @GetMapping("/visible")
    @Operation(summary = "Get all visible applications (for users)")
    public ResponseEntity<List<Application>> getAllVisibleApplications() {
        List<Application> apps = applicationService.getAllVisibleApplications();
        return ResponseEntity.ok(apps);
    }

    @GetMapping("/visible/search")
    @Operation(summary = "Search visible applications by name")
    public ResponseEntity<List<Application>> searchVisibleByName(@RequestParam String name) {
        List<Application> apps = applicationService.searchVisibleByName(name);
        return ResponseEntity.ok(apps);
    }

    @GetMapping("/visible/category/{category}")
    @Operation(summary = "Filter visible applications by category")
    public ResponseEntity<List<Application>> filterVisibleByCategory(@PathVariable String category) {
        List<Application> apps = applicationService.filterVisibleByCategory(category);
        return ResponseEntity.ok(apps);
    }

    @GetMapping("/visible/rating/{minRating}")
    @Operation(summary = "Filter visible applications by minimum rating")
    public ResponseEntity<List<Application>> filterVisibleByRating(@PathVariable Double minRating) {
        List<Application> apps = applicationService.filterVisibleByRating(minRating);
        return ResponseEntity.ok(apps);
    }
}
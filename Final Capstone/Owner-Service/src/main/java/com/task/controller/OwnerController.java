package com.task.controller;

import com.task.dto.LoginResponse;
import com.task.dto.OwnerDTO;
import com.task.model.Owner;
import com.task.service.OwnerService;
import com.task.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Owner Management", description = "APIs for owner operations")
public class OwnerController {
    
    @Autowired
    private OwnerService ownerService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @PostMapping("/register")
    @Operation(summary = "Register a new owner and return login response (auto-login)")
    public ResponseEntity<LoginResponse> registerOwner(@Valid @RequestBody OwnerDTO ownerDTO) {
        Owner owner = ownerService.registerOwner(ownerDTO);

        // generate token (same as login)
        String token = jwtUtil.generateToken(owner.getUsername(), owner.getId());

        // return same LoginResponse used by /login so frontend can store id/username/token
        LoginResponse response = new LoginResponse(
                token,
                owner.getId(),
                owner.getUsername(),
                owner.getEmail()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    
    @PostMapping("/login")
    @Operation(summary = "Login owner")
    public ResponseEntity<LoginResponse> loginOwner(@RequestParam String username, @RequestParam String password) {
        Owner owner = ownerService.loginOwner(username, password);
        
        // Generate JWT token
        String token = jwtUtil.generateToken(owner.getUsername(), owner.getId());
        
        // Create response with token
        LoginResponse response = new LoginResponse(
            token,
            owner.getId(),
            owner.getUsername(),
            owner.getEmail()
        );
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get owner by ID")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        Owner owner = ownerService.getOwnerById(id);
        return ResponseEntity.ok(owner);
    }
    
    @GetMapping
    @Operation(summary = "Get all owners")
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerService.getAllOwners();
        return ResponseEntity.ok(owners);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete owner")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.ok("Owner deleted successfully");
    }
}
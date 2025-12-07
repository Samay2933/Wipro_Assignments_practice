package com.task.service;

import com.task.dto.OwnerDTO;
import com.task.exception.CustomException;
import com.task.model.Owner;
import com.task.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class OwnerService {
	
    
    @Autowired
    private OwnerRepository ownerRepository;
    
    public Owner registerOwner(OwnerDTO ownerDTO) {
        if (ownerRepository.existsByUsername(ownerDTO.getUsername())) {
            throw new CustomException("Username already exists");
        }
        if (ownerRepository.existsByEmail(ownerDTO.getEmail())) {
            throw new CustomException("Email already exists");
        }
        
        Owner owner = new Owner();
        owner.setUsername(ownerDTO.getUsername());
        owner.setPassword(passwordEncoder.encode(ownerDTO.getPassword())); // ENCRYPT
        owner.setEmail(ownerDTO.getEmail());
        owner.setCompanyName(ownerDTO.getCompanyName());
        
        return ownerRepository.save(owner);
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Owner loginOwner(String username, String password) {
        Owner owner = ownerRepository.findByUsername(username)
            .orElseThrow(() -> new CustomException("Invalid username or password"));
        
        // Verify encrypted password
        if (!passwordEncoder.matches(password, owner.getPassword())) {
            throw new CustomException("Invalid username or password");
        }
        
        return owner;
    }
    
    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id)
            .orElseThrow(() -> new CustomException("Owner not found with id: " + id));
    }
    
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }
    
    public void deleteOwner(Long id) {
        if (!ownerRepository.existsById(id)) {
            throw new CustomException("Owner not found with id: " + id);
        }
        ownerRepository.deleteById(id);
    }
}
package com.task.service;

import com.task.dto.LoginRequest;
import com.task.dto.UserDTO;
import com.task.exception.CustomException;
import com.task.model.User;
import com.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
	
	
    
    @Autowired
    private UserRepository userRepository;
    
    public User registerUser(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new CustomException("Username already exists");
        }
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new CustomException("Email already exists");
        }
        
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // ENCRYPT PASSWORD
        user.setEmail(userDTO.getEmail());
        user.setFullName(userDTO.getFullName());
        
        return userRepository.save(user);
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
            .orElseThrow(() -> new CustomException("Invalid username or password"));
        
        // Verify encrypted password
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new CustomException("Invalid username or password");
        }
        
        return user;
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new CustomException("User not found with id: " + id));
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new CustomException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
    
}
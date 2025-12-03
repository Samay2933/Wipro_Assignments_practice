package com.task.service;

import com.task.dto.UserDTO;
import com.task.entity.User;
import com.task.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> addUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already registered.");
        }
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}

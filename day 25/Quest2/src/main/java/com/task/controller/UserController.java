package com.task.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.task.entity.User;
import com.task.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Can add PUT, DELETE as needed for updating/deleting users

}

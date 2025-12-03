package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    //get all users

    public List<User> getAllUsers(){
        //return this.userRepository.findAll();
    //}
    //get user by id
    //create user
    //update user
    //delete user by
        return null;
}
}

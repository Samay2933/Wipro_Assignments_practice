package com.secure.controller;

import com.secure.dto.UserRequestDTO;
import com.secure.entity.AppUser;
import com.secure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserRepository userRepository ;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home() {
        return "Home page";
    }

    @GetMapping("/public/welcome")
    public String getWelcome(){
        return "Welcome to our Hotel";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDTO userRequest){
        if(userRepository.findByUsername(userRequest.getUsername()).isPresent()){
            return  ResponseEntity.status(409).body("User already Exists");
        }
        AppUser user = new AppUser();

        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        user.setRole(userRequest.getRole() != null ? "ROLE_" + userRequest.getRole().toUpperCase() : "ROLE_USER" );

        userRepository.save(user);
        return ResponseEntity.status(201).body("User Registered successfully");
    }

    @GetMapping("api/user/userinfo")
    public String getVoucher(){
        return "Your voucher code is generated: ";
    }

    @GetMapping("/api/admin/admininfo")
    public String getUserInfo(){
        return "admin dashboard will get open";
    }
}

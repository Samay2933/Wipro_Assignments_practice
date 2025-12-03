package com.digest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HealthCheck {

    @GetMapping("/health-check") //directs here to this url
    public String healthCheck(){ //method
        return "OK";
    }
}

package com.springboot.repo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class Trial {

    @GetMapping("/trial")
    public String trial(){
        return "this is trial";

    }
}

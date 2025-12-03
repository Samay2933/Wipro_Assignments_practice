package com.learn;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class Config {

    @Bean
    Student student(){
        return new Student(); //IoC container
    }
}

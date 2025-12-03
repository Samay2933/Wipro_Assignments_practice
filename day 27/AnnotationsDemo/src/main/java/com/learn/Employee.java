package com.learn;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    public Employee() {
        System.err.println("Employee called constructor");
    }

    void m1(){
        System.err.println("m1() called");
    }
}

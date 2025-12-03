package com.bitsbytes;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    public MyComponent() {
        System.out.println("Result from MyComponent");
    }
    public static void getMessage() {
        System.out.println("Result from getMessage");
    }
}

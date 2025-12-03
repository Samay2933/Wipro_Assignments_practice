package com.bitsbytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoProductlistApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoProductlistApplication.class, args);

//        MyComponent myComponent = new MyComponent(); //done manually

        MyComponent myComponent = context.getBean(MyComponent.class);
        MyComponent.getMessage();
	}

}

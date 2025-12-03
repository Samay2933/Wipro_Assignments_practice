package com.learn;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class AnnotationsDemoApplication {

	public static void main(String[] args) {

        ConfigurableApplicationContext cfg= SpringApplication.run(AnnotationsDemoApplication.class, args);

        Student student = cfg.getBean(Student.class);

        System.out.println("ID: "+student.getId());
        System.out.println("Name: "+student.getName());

        Employee employee = cfg.getBean(Employee.class);
        employee.m1();
        cfg.close();
	}

}

//only run the aplication not the maven //maven gets error

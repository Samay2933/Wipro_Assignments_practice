package com.example.springboot.spBoot21._1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.spBoot21._1.bean.Employee;
import com.example.springboot.spBoot21._1.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    
    @Autowired
    EmployeeService empService;
    
    // URL: http://localhost:8085/api/add
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee emp1 = empService.createEmployee(employee);
        return new ResponseEntity<>(emp1, HttpStatus.CREATED);
    }
    
    // URL: http://localhost:8085/api/get
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getEmployee() {
        List<Employee> emp = empService.getAllEmployee();
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
    
    // URL: http://localhost:8085/api/get/1
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Employee emp = empService.getEmployeeById(id);
        if(emp == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
    
    // URL: http://localhost:8085/api/put/1
    @PutMapping("/put/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        Employee updated = empService.updateEmployee(id, employee);
        if(updated == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    // URL: http://localhost:8085/api/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        empService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }
}
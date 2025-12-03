package com.example.springboot.spBoot21._1.service;

import java.util.List;
import com.example.springboot.spBoot21._1.bean.Employee;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Integer id);
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Integer id , Employee employee);
    void deleteEmployee(Integer id); 
}
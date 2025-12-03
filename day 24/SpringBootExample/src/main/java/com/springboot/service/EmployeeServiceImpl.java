package com.springboot.service;

import com.example.bean.Employee;
import com.springboot.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // who will be saving the data for us and who will provide methods for all crud operations i.e. JpaRepository

    @Autowired
    EmployeeRepository empRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        // TODO Auto-generated method stub

        return empRepository.save(employee);
    }


    @Override
    public List<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        return empRepository.findAll();
    }
    @Override
    public Employee getEmployeeById(Integer id) {
        // TODO Auto-generated method stub

        return empRepository.findById(id).orElse(null);
    }


    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteEmployee(Integer id) {
        // TODO Auto-generated method stub

    }

}
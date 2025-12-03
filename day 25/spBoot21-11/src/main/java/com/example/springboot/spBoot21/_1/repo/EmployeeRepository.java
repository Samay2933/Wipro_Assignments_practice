package com.example.springboot.spBoot21._1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springboot.spBoot21._1.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    // This interface gives us the power to save, delete, and find data automatically.
}
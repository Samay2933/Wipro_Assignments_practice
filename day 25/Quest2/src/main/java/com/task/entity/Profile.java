package com.task.entity;

import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String role;
    private String department;
    @Column(length = 500)
    private String skills;

    // Getter and setter methods
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
}

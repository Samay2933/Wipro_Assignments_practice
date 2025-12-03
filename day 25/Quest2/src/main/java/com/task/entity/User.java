package com.task.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users") // to avoid H2 reserved word conflict
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 10)
    private String mobile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    // Getter and setter methods
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }
    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }
}

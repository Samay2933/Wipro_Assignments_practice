package com.task.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "labels") // to be explicit
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    private String colorCode;

    @ManyToMany(mappedBy = "labels")
    private Set<Task> tasks;

    // Getter and setter methods
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getColorCode() { return colorCode; }
    public void setColorCode(String colorCode) { this.colorCode = colorCode; }
    public Set<Task> getTasks() { return tasks; }
    public void setTasks(Set<Task> tasks) { this.tasks = tasks; }
}

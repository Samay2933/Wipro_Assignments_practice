package com.task.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tasks") // avoid reserved words
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    private String description;

    private String assignedTo;

    @Column(nullable = false)
    private String priority;

    @Column(nullable = false)
    private String status;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "task_label",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id")
    )
    private Set<Label> labels;

    // Getter and setter methods
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Set<Label> getLabels() { return labels; }
    public void setLabels(Set<Label> labels) { this.labels = labels; }
}

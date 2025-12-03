package com.task.repository;

import com.task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    User findByName(String name);
}

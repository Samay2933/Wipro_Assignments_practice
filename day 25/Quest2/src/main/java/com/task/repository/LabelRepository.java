package com.task.repository;

import com.task.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Integer> {
    boolean existsByName(String name);
}

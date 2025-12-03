package com.task.repository;

import com.task.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}

package com.secure.repository;

import com.secure.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {


    Optional<AppUser> findByUsername(String username);//when it will return a boolean so retur type
}

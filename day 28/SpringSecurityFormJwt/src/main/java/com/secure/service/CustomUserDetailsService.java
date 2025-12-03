package com.secure.service;

import com.secure.entity.AppUser;
import com.secure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found")); //add one more thing
        return new User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole()))

        );
    }
}

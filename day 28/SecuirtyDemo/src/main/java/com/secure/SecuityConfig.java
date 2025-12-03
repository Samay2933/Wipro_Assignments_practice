package com.secure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecuityConfig {

    //which of the below urls are secured /open and login method

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //.csrf(csrf -> csrf.disable()) //to disable for simple rest demo ; enable for forms
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/public/**").permitAll() // Open endpoint
                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // Secured, only ADMIN
                        .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN") // USER and ADMIN roles
                                .anyRequest().authenticated() // All other requests require authentication
                )
                .httpBasic(Customizer.withDefaults())
                      .formLogin(Customizer.withDefaults()); //by default login and logout urls are permitted for all

//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("/login") // Custom login page
//                                .permitAll() // Allow all to access the login page
//                )
//                .logout(logout -> logout
//                        .permitAll() // Allow all to perform logout
//                );
        return http.build();
    }

    //In-memory user for testing
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("sam")
                .password(passwordEncoder().encode("password")) // Encode the password
                //.password("password")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                //.password("adminpass")
                .password(passwordEncoder().encode("adminpass")) // Encode the password
                .roles("ADMIN", "USER") // Admin has both ADMIN and USER roles
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

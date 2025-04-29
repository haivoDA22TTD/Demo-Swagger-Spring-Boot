package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> 
                authorizeRequests
                    // Cho phép truy cập Swagger UI và các API docs
                    .requestMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**").permitAll()
                    // Chỉ yêu cầu xác thực cho các API khác, ví dụ: /api/**
                    .requestMatchers("/api/**").permitAll() 
                    .anyRequest().authenticated() // Các request khác yêu cầu xác thực
            )
            .csrf().disable(); // Tắt CSRF vì không cần thiết cho các API public

        return http.build();
    }
}

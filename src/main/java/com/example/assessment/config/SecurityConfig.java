package com.example.assessment.config;

import com.example.assessment.service.CustomUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final CustomUserDetails customUserDetails;

    public SecurityConfig(CustomUserDetails customUserDetails) {
        this.customUserDetails = customUserDetails;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(request -> request.requestMatchers(
                "/register", "/login"
        ).permitAll().anyRequest().authenticated()
        ).formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/welcome", true)
                .permitAll()).logout(logout ->
                logout.logoutSuccessUrl("/login").permitAll()).userDetailsService(customUserDetails);
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

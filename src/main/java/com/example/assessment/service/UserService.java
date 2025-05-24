package com.example.assessment.service;

import com.example.assessment.model.User;
import com.example.assessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public void registerUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        repository.save(user);
    }
}

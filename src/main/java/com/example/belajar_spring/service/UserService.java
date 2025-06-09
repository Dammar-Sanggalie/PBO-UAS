package com.example.belajar_spring.service;

import com.example.belajar_spring.model.User;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void init() {
        // Admin default
        users.put("admin", new User("admin", "admin123", "ADMIN"));
        
        // Tambah user default Kelompok 3
        users.put("Kelompok 3", new User("Kelompok 3", "123", "USER"));
    }

    public boolean register(String username, String password) {
        if (username == null || username.trim().isEmpty() || 
            password == null || password.trim().isEmpty()) {
            return false;
        }
        
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, password, "USER")); // User baru selalu role USER
        return true;
    }

    public User login(String username, String password) {
        if (username == null || password == null) {
            return null;
        }
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
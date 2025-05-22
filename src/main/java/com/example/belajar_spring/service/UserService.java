package com.example.belajar_spring.service;

import com.example.belajar_spring.model.User;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, String> users = new HashMap<>();

    @PostConstruct
    public void init() {
        // Add default users for testing
        users.put("Kelompok 3", "mieayam");
    }

    public boolean register(String username, String password) {
        if (username == null || username.trim().isEmpty() || 
            password == null || password.trim().isEmpty()) {
            return false;
        }
        
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        users.put(username, password);
        return true;
    }

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}
package com.example.belajar_spring.model;

public class User {
    private String username;
    private String password;
    private String role; // Tambahkan field role

    public User() {}

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Tambahkan getter setter untuk role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
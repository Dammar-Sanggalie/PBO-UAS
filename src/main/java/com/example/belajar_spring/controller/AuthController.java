package com.example.belajar_spring.controller;

import com.example.belajar_spring.service.UserService;
import com.example.belajar_spring.model.User; // Tambahkan import ini
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                       HttpServletRequest request, Model model) {
        User user = userService.login(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", username);
            session.setAttribute("userRole", user.getRole());
            
            // Redirect berdasarkan role
            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/admin/home"; // ke dashboard admin
            } else {
                return "redirect:/user/home"; // ke home user
            }
        }
        model.addAttribute("error", "Username atau password salah!");
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/auth/login";

    }

    @GetMapping("/register")
    public String registerForm() {
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.register(username, password)) {
            return "redirect:/auth/login";
        }
        model.addAttribute("error", "Username sudah ada!");
        return "auth/register";
    }

}
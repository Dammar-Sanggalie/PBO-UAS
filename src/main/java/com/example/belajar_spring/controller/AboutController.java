package com.example.belajar_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class AboutController {

    @GetMapping("/admin/about")
    public String adminAbout(Model model, HttpSession session) {
        String userRole = (String) session.getAttribute("userRole");
        if (!"ADMIN".equals(userRole)) {
            return "redirect:/auth/login";
        }
        
        model.addAttribute("activePage", "about");
        return "admin/about";
    }

    @GetMapping("/user/about")  // Changed from /user/aboutus
    public String userAbout(Model model, HttpSession session) {
        String userRole = (String) session.getAttribute("userRole");
        if (!"USER".equals(userRole)) {
            return "redirect:/auth/login";
        }
        
        model.addAttribute("activePage", "about");  // Changed from aboutus
        return "user/about";  // Changed from user/aboutus
    }
}
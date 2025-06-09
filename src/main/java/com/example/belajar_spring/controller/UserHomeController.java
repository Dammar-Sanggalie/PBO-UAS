package com.example.belajar_spring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.belajar_spring.service.KonserService;

@Controller
@RequestMapping("/user")
public class UserHomeController {
    
    @Autowired
    private KonserService konserService;
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        String userRole = (String) session.getAttribute("userRole");
        
        // Redirect admin ke dashboard
        if ("ADMIN".equals(userRole)) {
            return "redirect:/dashboard";
        }
        
        // Redirect user yang belum login
        if (userRole == null) {
            return "redirect:/auth/login";
        }

        model.addAttribute("daftarKonser", konserService.getAllKonser());
        return "user/home"; // ini akan mencari file di templates/user/home.html
    }
}
package com.example.belajar_spring.controller;

import com.example.belajar_spring.service.KonserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private KonserService konserService;

    @GetMapping({"admin", "/home"})
    public String home(HttpSession session, Model model) {
        String userRole = (String) session.getAttribute("userRole");
        
        if (userRole != null) {
            if ("ADMIN".equals(userRole)) {
                return "redirect:/admin/home";
            } else {
                return "redirect:/user/home";
            }
        }

        model.addAttribute("daftarKonser", konserService.getAllKonser());
        model.addAttribute("activePage", "home");
        return "admin/home";
    }

    @GetMapping("/admin/home")
    public String adminHome(Model model) {
        // Temporary solution without activityService
        model.addAttribute("daftarKonser", konserService.getAllKonser());
        model.addAttribute("activePage", "home");
        return "admin/home";
    }
}
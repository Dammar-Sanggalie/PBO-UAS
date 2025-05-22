package com.example.belajar_spring.controller;

import com.example.belajar_spring.service.KonserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private KonserService konserService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("daftarKonser", konserService.getAllKonser());
        model.addAttribute("activePage", "home");
        return "home";
    }
}
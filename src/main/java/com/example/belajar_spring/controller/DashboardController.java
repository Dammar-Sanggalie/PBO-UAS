package com.example.belajar_spring.controller;

import com.example.belajar_spring.service.KonserService;
import com.example.belajar_spring.service.TiketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private KonserService konserService;

    @Autowired
    private TiketService tiketService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalKonser", konserService.getAllKonser().size());
        model.addAttribute("totalTiket", tiketService.getTotalTiketTerjual());
        model.addAttribute("pendapatan", tiketService.getAllTiket().stream()
                .mapToDouble(t -> t.getTotalHarga()).sum());
        return "admin/dashboard"; // Make sure this points to admin/dashboard.html
    }
}
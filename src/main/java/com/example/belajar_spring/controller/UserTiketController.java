package com.example.belajar_spring.controller;

import com.example.belajar_spring.service.PemesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserTiketController {

    @Autowired
    private PemesananService pemesananService;

    @GetMapping("/tiket-saya")
    public String tiketSaya(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("loggedInUser");
        model.addAttribute("daftarPemesanan", pemesananService.getPemesananByUser(userId));
        return "user/tiket-saya";
    }
}
package com.example.belajar_spring.controller;

import com.example.belajar_spring.model.Tiket;
import com.example.belajar_spring.service.TiketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tiket")
public class TiketController {

    @Autowired
    private TiketService tiketService;

    @GetMapping
    public String daftarTiket(Model model) {
        model.addAttribute("activePage", "tiket");
        model.addAttribute("daftarTiket", tiketService.getAllTiket());
        return "tiket/index";
    }

    @GetMapping("/add")
    public String formTambahTiket(Model model) {
        model.addAttribute("activePage", "tiket");
        model.addAttribute("tiket", new Tiket());
        return "tiket/add";
    }

    @PostMapping("/add")
    public String simpanTiket(@ModelAttribute Tiket tiket) {
        tiketService.addTiket(tiket);
        return "redirect:/tiket";
    }
}
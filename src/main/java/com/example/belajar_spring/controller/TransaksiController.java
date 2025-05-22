package com.example.belajar_spring.controller;

import com.example.belajar_spring.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaksi")
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @GetMapping
    public String listTransaksi(Model model) {
        model.addAttribute("daftarTransaksi", transaksiService.getAllTransaksi());
        model.addAttribute("totalPendapatan", transaksiService.getTotalPendapatan());
        return "transaksi/index";
    }
}
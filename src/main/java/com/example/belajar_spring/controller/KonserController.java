package com.example.belajar_spring.controller;

import com.example.belajar_spring.model.Konser;
import com.example.belajar_spring.service.KonserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/konser")
public class KonserController {

    @Autowired
    private KonserService konserService;

    // Menampilkan daftar konser
    @GetMapping("")
    public String listKonser(Model model) {
        model.addAttribute("daftarKonser", konserService.getAllKonser());
        return "konser/index";
    }

    // Menampilkan form tambah konser
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("konser", new Konser());
        model.addAttribute("isEdit", false); // untuk bedakan form add/edit
        return "konser/add"; // file form berada di templates/konser/add.html
    }

    // Menangani proses simpan konser baru
    @PostMapping("/add")
    public String addKonser(@ModelAttribute Konser konser) {
        konser.setId(System.currentTimeMillis()); // Generate ID unik
        konserService.addKonser(konser);
        return "redirect:/konser";
    }

    

    // Menampilkan form edit konser berdasarkan ID
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Konser konser = konserService.getKonserById(id);
        if (konser == null) {
            return "redirect:/konser"; // kembalikan jika ID tidak ditemukan
        }
        model.addAttribute("konser", konser);
        model.addAttribute("isEdit", true);
        return "konser/add";
    }

    // Menangani proses update konser
    @PostMapping("/edit/{id}")
    public String editKonser(@PathVariable Long id, @ModelAttribute Konser konser) {
        konser.setId(id);
        konserService.updateKonser(konser);
        return "redirect:/konser";
    }

    // Menghapus konser berdasarkan ID
    @GetMapping("/delete/{id}")
    public String deleteKonser(@PathVariable Long id) {
        konserService.deleteKonser(id);
        return "redirect:/konser";
    }
    
}

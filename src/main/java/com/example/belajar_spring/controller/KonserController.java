package com.example.belajar_spring.controller;

import com.example.belajar_spring.model.Konser;
import com.example.belajar_spring.service.KonserService;

import java.util.ArrayList;
import java.util.List;

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
public String listKonser(
        @RequestParam(value = "search", required = false) String search,
        @RequestParam(value = "sort", required = false) String sort,
        Model model) {
    List<Konser> konserList = konserService.getAllKonser();

    // Searching
    if (search != null && !search.isEmpty()) {
        konserList = new ArrayList<>(
            konserList.stream()
                .filter(k -> k.getNamaKonser().toLowerCase().contains(search.toLowerCase()))
                .toList()
        );
    }

    // Sorting
    if ("nama".equals(sort)) {
        konserList.sort((a, b) -> a.getNamaKonser().compareToIgnoreCase(b.getNamaKonser()));
    } else if ("harga".equals(sort)) {
        konserList.sort((a, b) -> Double.compare(a.getHarga(), b.getHarga()));
    }

    model.addAttribute("daftarKonser", konserList);
    model.addAttribute("sort", sort);
    model.addAttribute("search", search);
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
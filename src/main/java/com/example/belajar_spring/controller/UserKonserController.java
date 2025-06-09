package com.example.belajar_spring.controller;

import com.example.belajar_spring.service.KonserService;
import com.example.belajar_spring.service.PemesananService;
import com.example.belajar_spring.model.Konser;
import com.example.belajar_spring.model.Pemesanan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user/konser")
public class UserKonserController {
    
    @Autowired
    private KonserService konserService;
    
    @Autowired
    private PemesananService pemesananService;

    @GetMapping
    public String listKonser(Model model) {
        model.addAttribute("konserList", konserService.getAllKonser());
        return "user/konser-list";
    }

    // Menampilkan detail konser untuk pemesanan
    @GetMapping("/{id}")
    public String detailKonser(@PathVariable Long id, Model model) {
        Konser konser = konserService.getKonserById(id);
        if (konser == null) {
            return "redirect:/user/home";
        }
        model.addAttribute("konser", konser);
        return "user/konser-detail";
    }
    
    // Handle proses pemesanan
    @PostMapping("/{id}/pesan")
    public String pesanTiket(@PathVariable Long id, 
                            @RequestParam int jumlahTiket,
                            HttpSession session,
                            RedirectAttributes redirectAttributes) {
        String userId = (String) session.getAttribute("loggedInUser");
        
        try {
            pemesananService.createPemesanan(userId, id, jumlahTiket);
            return "redirect:/user/tiket-saya";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Gagal melakukan pemesanan: " + e.getMessage());
            return "redirect:/user/konser/" + id;
        }
    }

    @GetMapping("/riwayat")
    public String riwayatPemesanan(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("loggedInUser");
        if (userId == null) {
            return "redirect:/auth/login";
        }

        model.addAttribute("pemesananList", pemesananService.getPemesananByUser(userId));
        return "user/riwayat-pemesanan";
    }
}
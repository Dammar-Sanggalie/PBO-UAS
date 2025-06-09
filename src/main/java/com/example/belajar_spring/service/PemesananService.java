package com.example.belajar_spring.service;

import com.example.belajar_spring.model.Pemesanan;
import com.example.belajar_spring.model.Konser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PemesananService {
    
    private List<Pemesanan> pemesananList = new ArrayList<>();
    
    @Autowired
    private KonserService konserService;

    public Pemesanan createPemesanan(String userId, Long konserId, int jumlahTiket) {
        Konser konser = konserService.getKonserById(konserId);
        
        if (konser == null || konser.getKuota() < jumlahTiket) {
            throw new RuntimeException("Kuota tidak mencukupi");
        }

        double totalHarga = konser.getHarga() * jumlahTiket;
        
        // Create new pemesanan using constructor
        Pemesanan pemesanan = new Pemesanan(
            generateId(),
            userId,
            konserId,
            jumlahTiket,
            totalHarga,
            LocalDateTime.now(),
            "PENDING"
        );
        
        // Update kuota konser
        konser.setKuota(konser.getKuota() - jumlahTiket);
        konserService.updateKonser(konser);
        
        pemesananList.add(pemesanan);
        return pemesanan;
    }

    public List<Pemesanan> getPemesananByUser(String userId) {
        return pemesananList.stream()
                .filter(p -> p.getUserId().equals(userId))
                .sorted(Comparator.comparing(Pemesanan::getTanggalPemesanan).reversed())
                .collect(Collectors.toList());
    }

    private Long generateId() {
        return System.currentTimeMillis();
    }
}
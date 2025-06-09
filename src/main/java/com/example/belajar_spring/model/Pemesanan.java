package com.example.belajar_spring.model;

import java.time.LocalDateTime;

public class Pemesanan {
    private Long id;
    private String userId;
    private Long konserId;
    private int jumlahTiket;
    private double totalHarga;
    private LocalDateTime tanggalPemesanan;
    private String status;
    private String namaKonser; // Added for display purposes
    
    public Pemesanan() {}
    
    public Pemesanan(Long id, String userId, Long konserId, int jumlahTiket, 
                     double totalHarga, LocalDateTime tanggalPemesanan, String status) {
        this.id = id;
        this.userId = userId;
        this.konserId = konserId;
        this.jumlahTiket = jumlahTiket;
        this.totalHarga = totalHarga;
        this.tanggalPemesanan = tanggalPemesanan;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public Long getKonserId() { return konserId; }
    public void setKonserId(Long konserId) { this.konserId = konserId; }
    
    public int getJumlahTiket() { return jumlahTiket; }
    public void setJumlahTiket(int jumlahTiket) { this.jumlahTiket = jumlahTiket; }
    
    public double getTotalHarga() { return totalHarga; }
    public void setTotalHarga(double totalHarga) { this.totalHarga = totalHarga; }
    
    public LocalDateTime getTanggalPemesanan() { return tanggalPemesanan; }
    public void setTanggalPemesanan(LocalDateTime tanggalPemesanan) { this.tanggalPemesanan = tanggalPemesanan; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNamaKonser() {
        return namaKonser;
    }

    public void setNamaKonser(String namaKonser) {
        this.namaKonser = namaKonser;
    }
}
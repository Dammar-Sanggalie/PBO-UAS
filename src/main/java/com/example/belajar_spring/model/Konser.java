package com.example.belajar_spring.model;

import java.time.LocalDate;

public class Konser {
    private Long id;
    private String namaKonser;
    private String lokasi;
    private LocalDate tanggal;
    private int kuota;
    private double harga;
    private String posterUrl;
// beserta getter & setter

    public Konser() {}

    public Konser(Long id, String namaKonser, String lokasi, LocalDate tanggal, int kuota, double harga, String posterUrl) {
        this.id = id;
        this.namaKonser = namaKonser;
        this.lokasi = lokasi;
        this.tanggal = tanggal;
        this.kuota = kuota;
        this.harga = harga;
        this.posterUrl = posterUrl;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKonser() {
        return namaKonser;
    }
    public void setNamaKonser(String namaKonser) {
        this.namaKonser = namaKonser;
    }

    public String getLokasi() {
        return lokasi;
    }
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }
    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public int getKuota() {
        return kuota;
    }
    public void setKuota(int kuota) {
        this.kuota = kuota;
    }

    public double getHarga() {
        return harga;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}

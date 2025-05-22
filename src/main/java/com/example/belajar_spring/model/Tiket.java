package com.example.belajar_spring.model;

public class Tiket {
    private Long id;
    private String namaPemesan;
    private String namaKonser;
    private int jumlah;
    private double totalHarga;

    public Tiket() {}

    public Tiket(Long id, String namaPemesan, String namaKonser, int jumlah, double totalHarga) {
        this.id = id;
        this.namaPemesan = namaPemesan;
        this.namaKonser = namaKonser;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaPemesan() {
        return namaPemesan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public String getNamaKonser() {
        return namaKonser;
    }

    public void setNamaKonser(String namaKonser) {
        this.namaKonser = namaKonser;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }
}

package com.example.belajar_spring.model;

public class Transaksi {
    private String namaPemesan;
    private String namaKonser;
    private int jumlah;
    private double totalHarga;

    public Transaksi() {}

    public Transaksi(String namaPemesan, String namaKonser, int jumlah, double totalHarga) {
        this.namaPemesan = namaPemesan;
        this.namaKonser = namaKonser;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
    }

    // Getter & Setter
    public String getNamaPemesan() { return namaPemesan; }
    public void setNamaPemesan(String namaPemesan) { this.namaPemesan = namaPemesan; }
    public String getNamaKonser() { return namaKonser; }
    public void setNamaKonser(String namaKonser) { this.namaKonser = namaKonser; }
    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }
    public double getTotalHarga() { return totalHarga; }
    public void setTotalHarga(double totalHarga) { this.totalHarga = totalHarga; }
}
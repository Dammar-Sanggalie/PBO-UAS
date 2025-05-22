package com.example.belajar_spring.service;

import com.example.belajar_spring.model.Transaksi;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

@Service
public class TransaksiService {
    private List<Transaksi> transaksiList = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Data dummy
        transaksiList.add(new Transaksi("Budi", "Konser Coldplay", 2, 1500000.0));
        transaksiList.add(new Transaksi("Siti", "Konser NCT Dream", 1, 550000.0));
    }

    public List<Transaksi> getAllTransaksi() {
        return transaksiList;
    }

    public double getTotalPendapatan() {
        return transaksiList.stream().mapToDouble(Transaksi::getTotalHarga).sum();
    }
}
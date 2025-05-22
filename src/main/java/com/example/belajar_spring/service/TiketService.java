package com.example.belajar_spring.service;

import com.example.belajar_spring.model.Tiket;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TiketService {
    private List<Tiket> tiketList = new ArrayList<>();
    private Long nextId = 2L; // Mulai dari 2 karena sudah ada data dummy dengan id 1

    @PostConstruct
    public void init() {
        tiketList.add(new Tiket(1L, "Budi", "Konser Coldplay", 2, 1500000.0));
        tiketList.add(new Tiket(2L, "Siti", "Konser NCT Dream", 1, 550000.0));
    }

    public List<Tiket> getAllTiket() {
        return tiketList;
    }

    public void addTiket(Tiket tiket) {
        // Set id otomatis jika null
        if (tiket.getId() == null) {
            tiket.setId(nextId++);
        }
        tiketList.add(tiket);
    }

    public int getTotalTiketTerjual() {
        return tiketList.stream().mapToInt(Tiket::getJumlah).sum();
    }
}
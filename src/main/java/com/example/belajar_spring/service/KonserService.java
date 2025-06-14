package com.example.belajar_spring.service;

import com.example.belajar_spring.model.Konser;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

@Service
public class KonserService {

    private List<Konser> konserList = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Data dummy awal
        konserList.add(new Konser(1L, "Konser Coldplay", "Jakarta", LocalDate.of(2025, 8, 1), 5000, 750000.0, "/poster/Konser Coldplay.jpg"));
        konserList.add(new Konser(2L, "Konser NCT Dream", "Surabaya", LocalDate.of(2025, 9, 15), 3000, 550000.0, "/poster/Konser NCT Dream.jpg"));
         konserList.add(new Konser(2L, "Dewok 24", "Maospati", LocalDate.of(2005, 9, 15), 10, 20000, "/poster/Dewok.jpg"));
    }

    // Mengambil semua konser
    public List<Konser> getAllKonser() {
        return new ArrayList<>(konserList); // return copy agar lebih aman
    }

    // Mencari konser berdasarkan ID
    public Konser getKonserById(Long id) {
        return konserList.stream()
                .filter(k -> k.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

 public void addKonser(Konser konser) {
    konserList.add(konser);
}

public void updateKonser(Konser konser) {
    for (int i = 0; i < konserList.size(); i++) {
        if (konserList.get(i).getId().equals(konser.getId())) {
            konserList.set(i, konser);
            return;
        }
    }
}

public void deleteKonser(Long id) {
    konserList.removeIf(k -> k.getId().equals(id));
}

public boolean updateKuota(Long konserId, int jumlahDipesan) {
        Konser konser = getKonserById(konserId);
        if (konser == null || konser.getKuota() < jumlahDipesan) {
            return false;
        }
        
        konser.setKuota(konser.getKuota() - jumlahDipesan);
        updateKonser(konser);
        return true;
    }
}

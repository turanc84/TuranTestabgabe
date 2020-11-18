package com.example.jpa.service;

import com.example.jpa.model.kunden;
import com.example.jpa.repository.RechnungRepository;
import com.example.jpa.repository.KundenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KundenService {

    private RechnungRepository rechnungRepository;
    private KundenRepository kundenRepository;

    public List<kunden> getAllKunden() {
        return kundenRepository.findAll();
    }


    public Optional<kunden> getKunde(Long id) {
        return kundenRepository.findById(id);
    }

    public kunden addKunde(kunden kunden){
        return kundenRepository.save(kunden);
    }

    public kunden editKunde(Long id, kunden kunden){
        kunden zuaendernderR = kundenRepository.getOne(id);
        zuaendernderR.setVorname(kunden.getVorname());
        zuaendernderR.setNachname(kunden.getNachname());
        return kundenRepository.save(zuaendernderR);
    }

    public void deleteKunde(Long id){
        kundenRepository.deleteById(id);
    }
}

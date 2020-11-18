package com.example.jpa.service;

import com.example.jpa.model.Rechnungen;
import com.example.jpa.model.kunden;
import com.example.jpa.repository.RechnungRepository;
import com.example.jpa.repository.KundenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RechnungService {

    private RechnungRepository rechnungRepository;
    private KundenRepository kundenRepository;

    public List<Rechnungen> getAllRechnungen() {
        return rechnungRepository.findAll();
    }

    public Optional<Rechnungen> getRechnung(Long id) {
        return rechnungRepository.findById(id);
    }

    public List<Rechnungen> getAllRechnungenByKunde(String kundenname)
    {
        return null;
    }

    public Rechnungen addRechnung(Long kundenid, Rechnungen rechnungen){
        Optional<kunden> kunden = kundenRepository.findById(kundenid);
        if(kunden.isPresent()){
            rechnungen.setKunde(kunden.get());
            return rechnungRepository.save(rechnungen);
        }
        return rechnungRepository.save(rechnungen);
    }

    public Rechnungen editRechnung(Long id, Rechnungen rechnungen){
        Rechnungen zuaendernderRechnung = rechnungRepository.getOne(id);
        zuaendernderRechnung.setRechnungsnummer(rechnungen.getRechnungsnummer());
        zuaendernderRechnung.setGenre(rechnungen.getReDatum());
        zuaendernderRechnung.setKunde(rechnungen.getKunde());
        return rechnungRepository.save(zuaendernderRechnung);
    }

    public void deleterechnung(Long id){
        rechnungRepository.deleteById(id);
    }


}




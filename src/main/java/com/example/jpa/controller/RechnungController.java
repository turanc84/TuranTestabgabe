package com.example.jpa.controller;


import com.example.jpa.model.Rechnungen;
import com.example.jpa.service.RechnungService;
import com.example.jpa.service.KundenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class RechnungController {

    @Autowired
    private RechnungService rechnungService;

    @Autowired
    private KundenService kundenService;

    @GetMapping("/rechnungen")
    public List<Rechnungen> getAllFilms(){
        return rechnungService.getAllRechnungen();
    }


    @GetMapping("/rechnungen/{filmid}")
    public Optional<Rechnungen> findFilmById(@PathVariable Long id){
        return rechnungService.getRechnung(id);
    }

    @PostMapping("/kunden/{rechnungenid}/rechnung")
    public Rechnungen createFilm(@PathVariable (value = "rechnungenid") Long regisseurId,
                                 @Valid @RequestBody Rechnungen rechnungen){
       return rechnungService.addRechnung(regisseurId, rechnungen);
    }

    @DeleteMapping("/rechnungen/{rechnungenid}")
    public ResponseEntity<?> deleteFilm(@PathVariable Long filmId) {
        rechnungService.deleterechnung(filmId);
        return ResponseEntity.ok("gelöscht");
    }

    @PutMapping("/rechnungen/{rechnungenid}/{kundenid}")
    public Rechnungen updateFilm(@PathVariable (value = "rechnungenid") Long regisseurId,
                                 @PathVariable Long filmId, @Valid @RequestBody Rechnungen request) {
        return rechnungService.editRechnung(filmId,request);
    }


}

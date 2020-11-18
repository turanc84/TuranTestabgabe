package com.example.jpa.controller;


import com.example.jpa.model.kunden;
import com.example.jpa.service.KundenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class KundenController {

    @Autowired
    private KundenService kundenService;

    @GetMapping("/kunde")
    public List<kunden> getAllKunden(){
        return kundenService.getAllKunden();
    }

    @GetMapping("/kunde/{kundenid")
    public Optional<kunden> getRegisseurById (@PathVariable Long id){
        return kundenService.getKunde(id);
    }

    @PostMapping("/kunde")
    public kunden createRegisseur (@RequestBody kunden kunden) {
        return kundenService.addKunde(kunden);
    }

    @PutMapping("/kunde/{kundenid}")
    public kunden updateRegisseur(@PathVariable Long kundenid, @Valid @RequestBody kunden kundenRequest){
        return kundenService.editKunde(kundenid, kundenRequest);
    }

    @DeleteMapping("/kunde/{kundenid}")
    public ResponseEntity<?> deleteKunde(@PathVariable Long kundenid){
        kundenService.deleteKunde(kundenid);
        return ResponseEntity.ok("gelöscht");
    }

}

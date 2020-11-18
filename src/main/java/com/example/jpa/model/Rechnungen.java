package com.example.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "rechnungen")
public class Rechnungen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Lob
    private Long rechnungsnummer;



    @NotNull
    @Lob
    private Double rechnungsbetrag;

    @NotNull
    private Date redatum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "kunden_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private kunden kunden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRechnungsnummer() {
        return rechnungsnummer;
    }

    public void setRechnungsnummer(Long rechnungsnummer) {
        this.rechnungsnummer = rechnungsnummer;
    }

    public Date getReDatum() {
        return redatum;
    }

    public void setGenre(Date redatum) {
        this.redatum = redatum;
    }

    public kunden getKunde() {
        return kunden;
    }

    public void setKunde(kunden kunden) {
        this.kunden = kunden;
    }

    public Double getRechnungsbetrag() {
        return rechnungsbetrag;
    }

    public void setRechnungsbetrag(Double rechnungsbetrag) {
        this.rechnungsbetrag = rechnungsbetrag;
    }
}

package com.example.jpa.repository;

import com.example.jpa.model.Rechnungen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechnungRepository extends JpaRepository<Rechnungen, Long> {

}

package com.example.jpa.repository;

import com.example.jpa.model.kunden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KundenRepository extends JpaRepository<kunden, Long> {

}

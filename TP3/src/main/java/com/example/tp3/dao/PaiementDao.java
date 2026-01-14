package com.example.tp3.dao;

import com.example.tp3.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {
}

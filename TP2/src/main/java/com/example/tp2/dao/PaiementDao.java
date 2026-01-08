package com.example.tp2.dao;

import com.example.tp2.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {
    Paiement findByCode(String code);
    int deleteByCommandeReference(String commandeReference);
    List<Paiement> findByCommandeReference(String commandeReference);
}

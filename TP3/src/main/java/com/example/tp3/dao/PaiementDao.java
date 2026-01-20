package com.example.tp3.dao;

import com.example.tp3.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {
    List<Paiement> findByCommandeRef(String ref);
    int deleteByCommandeRef(String commandeRef);
}

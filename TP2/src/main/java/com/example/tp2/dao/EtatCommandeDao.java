package com.example.tp2.dao;

import com.example.tp2.entity.EtatCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatCommandeDao extends JpaRepository<EtatCommande, Long> {
    EtatCommande findByCode(String code);
}

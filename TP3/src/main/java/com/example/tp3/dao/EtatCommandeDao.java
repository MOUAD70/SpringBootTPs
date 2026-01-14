package com.example.tp3.dao;

import com.example.tp3.entity.EtatCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatCommandeDao extends JpaRepository<EtatCommande, Long> {
    EtatCommande findByCode(String code);
}

package com.example.tp2.dao;

import com.example.tp2.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
    Commande findByReference(String reference);
    List<Commande> findByEtatCommandeCode(String code);
}

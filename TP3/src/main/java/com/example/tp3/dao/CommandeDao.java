package com.example.tp3.dao;

import com.example.tp3.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
    Commande findByRef(String ref);
}

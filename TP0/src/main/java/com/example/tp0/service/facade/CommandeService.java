package com.example.tp0.service.facade;

import com.example.tp0.entity.Commande;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeService {
    List<Commande> findAll();

    Commande findByRef(String ref);

    int save(Commande commande);

    int payer(String ref, BigDecimal montant);

    @Transactional
    int delete(String ref);
}

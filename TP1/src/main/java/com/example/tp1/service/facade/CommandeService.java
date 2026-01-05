package com.example.tp1.service.facade;

import com.example.tp1.entity.Commande;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeService {
    Commande findByReference(String reference);
    int save(Commande commande);
    int payer(String reference, BigDecimal montant);
    @Transactional
    int deleteByReference(String reference);
    List<Commande> findAll();

    List<Commande> findByTotalLessThan(BigDecimal total);
}

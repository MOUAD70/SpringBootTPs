package com.example.tp0_part2.service.facade;

import com.example.tp0_part2.entity.Commande;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeService {
    List<Commande> findAll();

    Commande findByRef(String ref);

    int save(Commande commande);

    int payer(String ref, BigDecimal montant);

    int delete(String ref);
}

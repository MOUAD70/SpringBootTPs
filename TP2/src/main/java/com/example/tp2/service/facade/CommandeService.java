package com.example.tp2.service.facade;

import com.example.tp2.entity.Commande;
import com.example.tp2.entity.Paiement;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CommandeService {
    List<Commande> findAll();

    Commande findByReference(String reference);
    int save(Commande commande);

    int payer(String reference, Paiement paiement);

    @Transactional
    int deleteByReference(String reference);

    List<Commande> findByEtatCommandeCode(String code);
}

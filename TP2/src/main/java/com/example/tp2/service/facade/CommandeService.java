package com.example.tp2.service.facade;

import com.example.tp2.entity.Commande;
import com.example.tp2.entity.Paiement;
import jakarta.transaction.Transactional;

public interface CommandeService {
    Commande findByReference(String reference);
    int save(Commande commande);

    int payer(String commandeReference, Paiement paiement);

    @Transactional
    int deleteByReference(String commandeReference);
}

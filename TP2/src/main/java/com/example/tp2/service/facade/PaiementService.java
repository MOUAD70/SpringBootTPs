package com.example.tp2.service.facade;

import com.example.tp2.entity.Paiement;

import java.util.List;

public interface PaiementService {
    Paiement findByCode(String code);

    int save(Paiement paiement);

    List<Paiement> findByCommandeReference(String commandeReference);

    int deleteByCommandeReference(String reference);
}

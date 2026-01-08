package com.example.tp2.service.facade;

import com.example.tp2.entity.Paiement;

import java.util.List;

public interface PaiementService {
    List<Paiement> findAll();

    Paiement findByCode(String code);

    int save(Paiement paiement);

    List<Paiement> findByCommandeReference(String reference);

    int deleteByCommandeReference(String reference);
}

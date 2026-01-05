package com.example.tp2.service.facade;

import com.example.tp2.entity.Paiement;

public interface PaiementService {
    Paiement findByCode(String code);

    int save(Paiement paiement);
}

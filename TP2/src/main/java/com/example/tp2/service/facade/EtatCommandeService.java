package com.example.tp2.service.facade;

import com.example.tp2.entity.EtatCommande;

public interface EtatCommandeService {
    void save(EtatCommande etatCommande);

    EtatCommande findByCode(String code);

    EtatCommande findInit();
    EtatCommande findInProgress();
    EtatCommande findFinalised();
}

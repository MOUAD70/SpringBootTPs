package com.example.tp3.service.facade;

import com.example.tp3.entity.EtatCommande;

import java.util.List;

public interface EtatCommandeService {
    List<EtatCommande> findAll();

    EtatCommande findByCode(String code);

    EtatCommande findInit();

    EtatCommande findInProgress();


    EtatCommande findFinished();
}

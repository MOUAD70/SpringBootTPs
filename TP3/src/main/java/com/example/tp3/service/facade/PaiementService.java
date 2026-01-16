package com.example.tp3.service.facade;

import com.example.tp3.entity.Paiement;

import java.util.List;

public interface PaiementService {
    List<Paiement> findByCommandeRef(String ref);
}

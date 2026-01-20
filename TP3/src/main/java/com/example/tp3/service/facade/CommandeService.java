package com.example.tp3.service.facade;

import com.example.tp3.entity.Commande;

import java.util.List;

public interface CommandeService {
    List<Commande> findAll();

    Commande findByRef(String ref);

    int save(Commande commande);

    int delete(String commandeRef);
}

package com.example.tp3.dao;

import com.example.tp3.entity.Commande;
import com.example.tp3.entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeItemDao extends JpaRepository<CommandeItem, Long> {
    List<CommandeItem> findByCommandeRef(String ref);

    CommandeItem commande(Commande commande);.
}

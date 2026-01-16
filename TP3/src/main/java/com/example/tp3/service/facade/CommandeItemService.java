package com.example.tp3.service.facade;

import com.example.tp3.entity.CommandeItem;

import java.util.List;

public interface CommandeItemService {
    List<CommandeItem> findByCommandeRef(String ref);

    void save(CommandeItem commandeItem);
}

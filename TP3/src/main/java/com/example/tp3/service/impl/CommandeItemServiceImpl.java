package com.example.tp3.service.impl;

import com.example.tp3.dao.CommandeItemDao;
import com.example.tp3.entity.CommandeItem;
import com.example.tp3.service.facade.CommandeItemService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeItemServiceImpl implements CommandeItemService {

    @Override
    public List<CommandeItem> findByCommandeRef(String ref) {
        return dao.findByCommandeRef(ref);
    }

    @Override
    public void save(CommandeItem commandeItem) {
        dao.save(commandeItem);
    }

    @Transactional
    @Override
    public int deleteByCommandeRef(String commandeRef) {
        return dao.deleteByCommandeRef(commandeRef);
    }

    private CommandeItemDao dao;

    public CommandeItemServiceImpl(CommandeItemDao dao) {
        this.dao = dao;
    }
}

package com.example.tp3.service.impl;

import com.example.tp3.dao.CommandeItemDao;
import com.example.tp3.entity.CommandeItem;
import com.example.tp3.service.facade.CommandeItemService;
import org.springframework.stereotype.Service;

@Service
public class CommandeItemServiceImpl implements CommandeItemService {

    @Override
    public void save(CommandeItem commandeItem) {
        dao.save(commandeItem);
    }

    private CommandeItemDao dao;

    public CommandeItemServiceImpl(CommandeItemDao dao) {
        this.dao = dao;
    }
}

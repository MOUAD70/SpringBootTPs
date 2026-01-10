package com.example.tp0_part2.service.impl;

import com.example.tp0_part2.dao.CommandeItemDao;
import com.example.tp0_part2.entity.CommandeItem;
import com.example.tp0_part2.service.facade.CommandeItemService;
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

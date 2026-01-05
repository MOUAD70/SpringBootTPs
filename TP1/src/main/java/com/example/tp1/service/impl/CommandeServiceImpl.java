package com.example.tp1.service.impl;

import com.example.tp1.dao.CommandeDao;
import com.example.tp1.entity.Commande;
import com.example.tp1.service.facade.CommandeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {

    private CommandeDao commandeDao;

    public CommandeServiceImpl(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    @Override
    public List<Commande> findByTotalLessThan(BigDecimal total) {
        return commandeDao.findByTotalLessThan(total);
    }

    @Override
    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    @Override
    public int save(Commande commande) {
        Commande commandeRef = findByReference(commande.getReference());
        if (commandeRef != null) return -1;
        else {
            commandeDao.save(commande);
            return 1;
        }
    }

    @Override
    public int payer(String reference, BigDecimal montant) {
        Commande commande = findByReference(reference);
        if (reference == null) return -1;
        else if (commande.getTotalPaye().add(montant).compareTo(commande.getTotal()) > 0) return -2;
        else {
            BigDecimal nvTotalPaye = commande.getTotalPaye().add(montant);
            commande.setTotalPaye(nvTotalPaye);
            commandeDao.save(commande);
            return 1;
        }
    }

    @Transactional
    @Override
    public int deleteByReference(String reference) {
        Commande commande = findByReference(reference);
        if (reference == null) return -1;
        else if (commande.getTotalPaye().compareTo(BigDecimal.ZERO) != 0) return -2;
        else {
            commandeDao.delete(commande);
            return 1;
        }
    }
}

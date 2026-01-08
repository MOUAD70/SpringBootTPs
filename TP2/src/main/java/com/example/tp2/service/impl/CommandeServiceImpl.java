package com.example.tp2.service.impl;

import com.example.tp2.dao.CommandeDao;
import com.example.tp2.entity.Commande;
import com.example.tp2.entity.Paiement;
import com.example.tp2.service.facade.CommandeService;
import com.example.tp2.service.facade.EtatCommandeService;
import com.example.tp2.service.facade.PaiementService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    private CommandeDao commandeDao;
    private EtatCommandeService etatCommandeService;
    private PaiementService paiementService;

    public CommandeServiceImpl(CommandeDao commandeDao, EtatCommandeService etatCommandeService, PaiementService paiementService) {
        this.commandeDao = commandeDao;
        this.etatCommandeService = etatCommandeService;
        this.paiementService = paiementService;
    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
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
            commande.setEtatCommande(etatCommandeService.findInit());
            commandeDao.save(commande);
            return 1;
        }
    }

    @Override
    public int payer(String reference, Paiement paiement) {
        Commande commande = findByReference(reference);
        if (commande == null) return -1;
        else if (paiement.getMontant().add(commande.getTotalPaye()).compareTo(commande.getTotal()) > 0) return -2;
        else {
            BigDecimal nvTotalPaye = paiement.getMontant().add(commande.getTotalPaye());
            commande.setTotalPaye(nvTotalPaye);
            if (nvTotalPaye.compareTo(commande.getTotal()) < 0) {
                commande.setEtatCommande(etatCommandeService.findInProgress());
            } else if (nvTotalPaye.compareTo(commande.getTotal()) == 0) {
                commande.setEtatCommande(etatCommandeService.findFinalised());
            }
            commandeDao.save(commande);
            paiementService.save(paiement);

            return 1;
        }
    }

    @Transactional
    @Override
    public int deleteByReference(String reference) {
        Commande commande = findByReference(reference);
        if (commande.getTotalPaye().compareTo(BigDecimal.ZERO) != 0) return -1;
        else {
            commandeDao.delete(commande);
            return 1;
        }
    }

    @Override
    public List<Commande> findByEtatCommandeCode(String etatCommandeCode) {
        return commandeDao.findByEtatCommandeCode(etatCommandeCode);
    }

}


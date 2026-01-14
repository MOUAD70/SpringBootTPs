package com.example.tp3.service.impl;

import com.example.tp3.dao.CommandeDao;
import com.example.tp3.entity.Commande;
import com.example.tp3.entity.CommandeItem;
import com.example.tp3.service.facade.CommandeItemService;
import com.example.tp3.service.facade.CommandeService;
import com.example.tp3.service.facade.EtatCommandeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Override
    public List<Commande> findAll() {
        return dao.findAll();
    }

    @Override
    public Commande findByRef(String ref) {
        return dao.findByRef(ref);
    }

    @Override
    public int save(Commande commande) {
        if (findByRef(commande.getRef()) != null) return -1;
        else {
            BigDecimal total = BigDecimal.ZERO;
            List<CommandeItem> commandeItems = commande.getCommandeItems();
            for (CommandeItem commandeItem : commandeItems) {
                BigDecimal calcTotal = commandeItem.getPrix().multiply(commandeItem.getQuantite());
                total = total.add(calcTotal);
                commandeItem.setCommande(commande);
            }
            commande.setTotal(total);

            commande.setEtatCommande(etatCommandeService.findInit());

            dao.save(commande);
            if (commande.getCommandeItems() != null) {
                for (CommandeItem item : commande.getCommandeItems()) {
                    commandeItemService.save(item);
                }
            }
            return 1;
        }
    }




    private CommandeDao dao;
    private EtatCommandeService etatCommandeService;
    private CommandeItemService commandeItemService;

    public CommandeServiceImpl(CommandeDao dao, EtatCommandeService etatCommandeService, CommandeItemService commandeItemService) {
        this.dao = dao;
        this.etatCommandeService = etatCommandeService;
        this.commandeItemService = commandeItemService;
    }
}

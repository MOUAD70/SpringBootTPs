package com.example.tp0_part2.service.impl;

import com.example.tp0_part2.dao.CommandeDao;
import com.example.tp0_part2.entity.Commande;
import com.example.tp0_part2.entity.CommandeItem;
import com.example.tp0_part2.service.facade.CommandeItemService;
import com.example.tp0_part2.service.facade.CommandeService;
import jakarta.transaction.Transactional;
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
        if (dao.findByRef(commande.getRef()) != null) {
            return -1;
        }else {
             BigDecimal total = BigDecimal.ZERO;
             List<CommandeItem> commandeItems = commande.getCommandeItems();
             for (CommandeItem commandeItem : commandeItems) {
                 total = total.add(commandeItem.getPrix().multiply(commandeItem.getQuantite()));
             }
             commande.setTotal(total);
             dao.save(commande);

             for (CommandeItem commandeItem : commandeItems) {
                 commandeItem.setCommande(commande);
                 commandeItemService.save(commandeItem);
             }
            return 1;
        }
    }

    @Override
    public int payer(String ref, BigDecimal montant) {
        Commande commande = findByRef(ref);
        if (commande == null) return -1;
        else if (commande.getTotalPaye().add(montant).compareTo(commande.getTotal()) > 0) return -2;
        else {
            BigDecimal nvTotalPaye = commande.getTotalPaye().add(montant);
            commande.setTotal(nvTotalPaye);
            dao.save(commande);
            return 1;
        }
    }
    @Transactional
    @Override
    public int delete(String ref) {
        Commande commande = findByRef(ref);
        if (commande.getTotalPaye().compareTo(BigDecimal.ZERO) != 0) return -1;
        else {
            dao.delete(commande);
            return 1;
        }
    }


    private CommandeDao dao;
    private CommandeItemService commandeItemService;

    public CommandeServiceImpl(CommandeDao dao, CommandeItemService commandeItemService) {
        this.dao = dao;
        this.commandeItemService = commandeItemService;
    }
}

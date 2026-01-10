package com.example.tp0.service.impl;

import com.example.tp0.dao.CommandeDao;
import com.example.tp0.entity.Commande;
import com.example.tp0.service.facade.CommandeService;
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
        if (dao.findByRef(commande.getRef()) != null ) {
            return -1;
        }else {
            dao.save(commande);
            return 1;
        }
    }

    @Override
    public int payer(String ref, BigDecimal montant) {
        Commande commande = findByRef(ref);
        if (!commande.getRef().equals(ref)) {
                return -1;
        }else if (commande.getTotalPaye().add(montant).compareTo(commande.getTotal()) > 0) {
            return -2;
        }
        else {
            BigDecimal nvTotalPaye = commande.getTotalPaye().add(montant);
            commande.setTotalPaye(nvTotalPaye);
            dao.save(commande);
            return 1;
        }
    }

    @Transactional
    @Override
    public int delete(String ref) {
        Commande commande = findByRef(ref);
        if (!commande.getRef().equals(ref)) {
            return -1;
        }else {
            dao.delete(commande);
            return 1;
        }
    }

    private CommandeDao dao;

    public CommandeServiceImpl(CommandeDao dao) {
        this.dao = dao;
    }
}

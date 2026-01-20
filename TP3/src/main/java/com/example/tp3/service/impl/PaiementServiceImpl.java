package com.example.tp3.service.impl;

import com.example.tp3.dao.PaiementDao;
import com.example.tp3.entity.Paiement;
import com.example.tp3.service.facade.PaiementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {

    @Override
    public int deleteByCommandeRef(String commandeRef) {
        return dao.deleteByCommandeRef(commandeRef);
    }

    @Override
    public List<Paiement> findByCommandeRef(String ref) {
        return dao.findByCommandeRef(ref);
    }

    private PaiementDao dao;

    public PaiementServiceImpl(PaiementDao dao) {
        this.dao = dao;
    }


}

package com.example.tp2.service.impl;

import com.example.tp2.dao.PaiementDao;
import com.example.tp2.entity.Paiement;
import com.example.tp2.service.facade.PaiementService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {
    private PaiementDao paiementDao;

    public PaiementServiceImpl(PaiementDao paiementDao) {
        this.paiementDao = paiementDao;
    }

    @Override
    public List<Paiement> findAll() {
        return paiementDao.findAll();
    }

    @Override
    public Paiement findByCode(String code) {
        return paiementDao.findByCode(code);
    }

    @Override
    public int save(Paiement paiement) {
        if (findByCode(paiement.getCode()) == null) return -1;
        else {
            paiementDao.save(paiement);
            return 1;
        }
    }

    @Override
    public List<Paiement> findByCommandeReference(String commandeReference) {
        return paiementDao.findByCommandeReference(commandeReference);
    }

    @Transactional
    @Override
    public int deleteByCommandeReference(String commandeReference) {
        return paiementDao.deleteByCommandeReference(commandeReference);
    }

}

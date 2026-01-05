package com.example.tp2.service.impl;

import com.example.tp2.dao.EtatCommandeDao;
import com.example.tp2.entity.EtatCommande;
import com.example.tp2.service.facade.EtatCommandeService;
import org.springframework.stereotype.Service;

@Service
public class EtatCommandeServiceImpl implements EtatCommandeService {
    private EtatCommandeDao etatCommandeDao;

    public EtatCommandeServiceImpl(EtatCommandeDao etatCommandeDao) {
        this.etatCommandeDao = etatCommandeDao;
    }

    @Override
    public void save(EtatCommande etatCommande) {
        etatCommandeDao.save(etatCommande);
    }

    @Override
    public EtatCommande findByCode(String code) {
        return etatCommandeDao.findByCode(code);
    }

    @Override
    public EtatCommande findInit() {
        return findByCode("INIT");
    }

    @Override
    public EtatCommande findInProgress() {
        return findByCode("IN_PROGRESS");
    }

    @Override
    public EtatCommande findFinalised() {
        return findByCode("FINALISED");
    }



}
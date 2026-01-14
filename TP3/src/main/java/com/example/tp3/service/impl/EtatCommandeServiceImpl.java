package com.example.tp3.service.impl;

import com.example.tp3.dao.EtatCommandeDao;
import com.example.tp3.entity.EtatCommande;
import com.example.tp3.service.facade.EtatCommandeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtatCommandeServiceImpl implements EtatCommandeService {
    public static final String INIT = "init";
    public static final String FINISHED = "finished";
    private static final String IN_PROGRESS = "inProgress";

    @Override
    public List<EtatCommande> findAll() {
        return dao.findAll();
    }

    @Override
    public EtatCommande findByCode(String code) {
        return dao.findByCode(code);
    }


    @Override
    public EtatCommande findInit() {
        return findByCode(INIT);
    }

    @Override
    public EtatCommande findInProgress() {
        return findByCode(IN_PROGRESS);
    }

    @Override
    public EtatCommande findFinished() {
        return findByCode(FINISHED);
    }


    private EtatCommandeDao dao;

    public EtatCommandeServiceImpl(EtatCommandeDao dao) {
        this.dao = dao;
    }
}

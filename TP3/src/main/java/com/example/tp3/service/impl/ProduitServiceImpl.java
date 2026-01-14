package com.example.tp3.service.impl;

import com.example.tp3.dao.ProduitDao;
import com.example.tp3.service.facade.ProduitService;
import org.springframework.stereotype.Service;

@Service
public class ProduitServiceImpl implements ProduitService {

    private ProduitDao dao;

    public ProduitServiceImpl(ProduitDao dao) {
        this.dao = dao;
    }
}

package com.example.tp3.service.impl;

import com.example.tp3.dao.PaiementDao;
import com.example.tp3.service.facade.PaiementService;
import org.springframework.stereotype.Service;

@Service
public class PaiementServiceImpl implements PaiementService {

    private PaiementDao dao;

    public PaiementServiceImpl(PaiementDao dao) {
        this.dao = dao;
    }
}

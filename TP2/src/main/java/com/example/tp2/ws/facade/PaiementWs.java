package com.example.tp2.ws.facade;

import com.example.tp2.entity.Paiement;
import com.example.tp2.service.facade.PaiementService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Paiements")
public class PaiementWs {
    private PaiementService paiementService;

    public PaiementWs(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping()
    public List<Paiement> findAll(){
        return paiementService.findAll();
    }

    @GetMapping("/code/{code}")
    public Paiement findByCode(@PathVariable String code) {
        return paiementService.findByCode(code);
    }

    @PostMapping()
    public int save(@RequestBody Paiement paiement) {
        return paiementService.save(paiement);
    }

    @GetMapping("/commandeReference/{commandeReference}")
    public List<Paiement> findByCommandeReference(String commandeReference) {
        return paiementService.findByCommandeReference(commandeReference);
    }

    @Transactional
    @DeleteMapping("/commandeReference/{commandeReference}")
    public int deleteByCommandeReference(@PathVariable String commandeReference) {
        return paiementService.deleteByCommandeReference(commandeReference);
    }
}

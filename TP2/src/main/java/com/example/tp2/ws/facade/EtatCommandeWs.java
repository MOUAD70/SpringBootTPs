package com.example.tp2.ws.facade;

import com.example.tp2.entity.EtatCommande;
import com.example.tp2.service.facade.EtatCommandeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/etat-commandes")
public class EtatCommandeWs {
    private EtatCommandeService etatCommandeService;

    public EtatCommandeWs(EtatCommandeService etatCommandeService) {
        this.etatCommandeService = etatCommandeService;
    }

    @PostMapping()
    public void save(@RequestBody EtatCommande etatCommande) {
        etatCommandeService.save(etatCommande);
    }

    @GetMapping("/code/{code}")
    public EtatCommande findByCode(@PathVariable String code) {
        return etatCommandeService.findByCode(code);
    }
}

package com.example.tp2.ws.facade;

import com.example.tp2.entity.Commande;
import com.example.tp2.entity.Paiement;
import com.example.tp2.service.facade.CommandeService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeWs {
    private CommandeService commandeService;

    public CommandeWs(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping()
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @GetMapping("/reference/{reference}")
    public Commande findByReference(@PathVariable String reference) {
        return commandeService.findByReference(reference);
    }

    @PostMapping()
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @PutMapping("/reference/{reference}/paiement/{paiement}")
    public int payer(@PathVariable String reference, @PathVariable Paiement paiement) {
        return commandeService.payer(reference, paiement);
    }

    @Transactional
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return commandeService.deleteByReference(reference);
    }

    @GetMapping("/etatCommandeCode/{etatCommandeCode}")
    public List<Commande> findByEtatCommandeCode(@PathVariable String etatCommandeCode) {
        return commandeService.findByEtatCommandeCode(etatCommandeCode);
    }
}

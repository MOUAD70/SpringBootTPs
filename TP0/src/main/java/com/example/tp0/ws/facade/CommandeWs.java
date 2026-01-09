package com.example.tp0.ws.facade;

import com.example.tp0.entity.Commande;
import com.example.tp0.service.facade.CommandeService;
import com.example.tp0.ws.converter.CommandeConverter;
import com.example.tp0.ws.dto.CommandeDto;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeWs {

    @GetMapping
    public List<CommandeDto> findAll() {
        List<Commande> commandes = service.findAll();
        return converter.toDtos(commandes);
    }

    @GetMapping("/ref/{ref}")
    public CommandeDto findByRef(@PathVariable String ref) {
        Commande commande = service.findByRef(ref);
        return converter.toDto(commande);
    }

    @PostMapping
    public int save(@RequestBody Commande commande) {
        return service.save(commande);
    }

    @PutMapping("/ref/{ref}/montant/{montant}")
    public int payer(@PathVariable String ref, @PathVariable BigDecimal montant) {
        return service.payer(ref, montant);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int delete(@PathVariable String ref) {
        return service.delete(ref);
    }

    private CommandeService service;
    private CommandeConverter converter;

    public CommandeWs(CommandeService service, CommandeConverter converter) {
        this.service = service;
        this.converter = converter;
    }
}

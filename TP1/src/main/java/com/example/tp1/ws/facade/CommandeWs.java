package com.example.tp1.ws.facade;

import com.example.tp1.entity.Commande;
import com.example.tp1.service.facade.CommandeService;
import com.example.tp1.ws.converter.CommandeConverter;
import com.example.tp1.ws.dto.CommandeDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeWs {
    CommandeService commandeService;
    CommandeConverter commandeConverter;

    public CommandeWs(CommandeService commandeService, CommandeConverter commandeConverter) {
        this.commandeService = commandeService;
        this.commandeConverter = commandeConverter;
    }

    @GetMapping
    public List<CommandeDto> findAll() {
        List<Commande> commandes = commandeService.findAll();
        return commandeConverter.toDtos(commandes);
    }

    @GetMapping("/total/{total}")
    public List<CommandeDto> findByTotalLessThan(@PathVariable BigDecimal total) {
        List<Commande> commandes = commandeService.findByTotalLessThan(total);
        return commandeConverter.toDtos(commandes);
    }

    @GetMapping("/reference/{reference}")
    public CommandeDto findByReference(@PathVariable String reference) {
        Commande commande = commandeService.findByReference(reference);
        return commandeConverter.toDto(commande);
    }

    @PostMapping
    public int save(@RequestBody CommandeDto commandeDto) {
        Commande commande = commandeConverter.toEntity(commandeDto);
        return commandeService.save(commande);
    }

    @PutMapping("/reference/{reference}/montant/{montant}")
    public int payer(@PathVariable String reference, @PathVariable BigDecimal montant) {
        return commandeService.payer(reference, montant);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return commandeService.deleteByReference(reference);
    }
}

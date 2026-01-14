package com.example.tp3.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private BigDecimal total;
    private BigDecimal totalPaye;

    @ManyToOne
    private EtatCommande etatCommande;

    @OneToMany
    private List<CommandeItem> commandeItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(BigDecimal totalPaye) {
        this.totalPaye = totalPaye;
    }

    public EtatCommande getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(EtatCommande etatCommande) {
        this.etatCommande = etatCommande;
    }

    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<CommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
    }
}

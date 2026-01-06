package com.example.tp2.ws.dto;
import com.example.tp2.entity.Commande;
import jakarta.persistence.*;

public class EtatCommandeDto {

    private String code;
    private String libelle;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}


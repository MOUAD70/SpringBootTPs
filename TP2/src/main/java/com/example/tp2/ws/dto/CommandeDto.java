package com.example.tp2.ws.dto;

import com.example.tp2.entity.EtatCommande;
import jakarta.persistence.*;

import java.math.BigDecimal;

public class CommandeDto {
    private String reference;
    private BigDecimal total;
    private BigDecimal totalPaye;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

}

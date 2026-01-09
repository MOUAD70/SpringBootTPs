package com.example.tp0.ws.dto;


import java.math.BigDecimal;

public class CommandeDto {

    private String ref;
    private BigDecimal total;
    private BigDecimal totalPaye;

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
}

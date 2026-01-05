package com.example.tp1.dao;

import com.example.tp1.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
    Commande findByReference(String reference);

    @Query("SELECT c FROM Commande c WHERE c.total >= :total")
    List<Commande> findByTotalLessThan(BigDecimal total);


}

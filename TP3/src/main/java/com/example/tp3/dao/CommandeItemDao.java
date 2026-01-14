package com.example.tp3.dao;

import com.example.tp3.entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeItemDao extends JpaRepository<CommandeItem, Long> {

}

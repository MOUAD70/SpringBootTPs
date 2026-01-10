package com.example.tp0_part2.dao;

import com.example.tp0_part2.entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeItemDao extends JpaRepository<CommandeItem, Long> {
}

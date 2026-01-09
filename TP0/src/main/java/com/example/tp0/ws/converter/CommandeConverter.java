package com.example.tp0.ws.converter;

import com.example.tp0.entity.Commande;
import com.example.tp0.ws.dto.CommandeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandeConverter {
    public Commande toEntity(CommandeDto dto) {
        Commande entity = new Commande();

        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    public CommandeDto toDto(Commande entity) {
        CommandeDto dto = new CommandeDto();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }

    public List<Commande> toEntities(List<CommandeDto> dtos) {
        return dtos.stream().map(this::toEntity).toList();
    }

    public List<CommandeDto> toDtos(List<Commande> entities) {
        return entities.stream().map(this::toDto).toList();
    }

}

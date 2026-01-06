package com.example.tp2.ws.converter;

import com.example.tp2.entity.EtatCommande;
import com.example.tp2.ws.dto.EtatCommandeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EtatCommandeConverter {

    public EtatCommande toEntity(EtatCommandeDto dto) {
        EtatCommande entity = new EtatCommande();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    public EtatCommandeDto toDto(EtatCommande entity) {
        EtatCommandeDto dto = new EtatCommandeDto();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }

    public List<EtatCommande> toEntities(List<EtatCommandeDto> dtos) {
        return dtos.stream().map(this::toEntity).toList();
    }

    public List<EtatCommandeDto> toDtos(List<EtatCommande> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}

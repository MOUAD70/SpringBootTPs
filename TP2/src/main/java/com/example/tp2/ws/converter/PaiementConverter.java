package com.example.tp2.ws.converter;

import com.example.tp2.entity.Paiement;
import com.example.tp2.ws.dto.PaiementDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaiementConverter {
    public Paiement toEntity(PaiementDto dto) {
        Paiement entity = new Paiement();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    public PaiementDto toDto(Paiement entity) {
        PaiementDto dto = new PaiementDto();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }

    public List<Paiement> toEntities(List<PaiementDto> dtos) {
        return dtos.stream().map(this::toEntity).toList();
    }

    public List<PaiementDto> toDtos(List<Paiement> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}

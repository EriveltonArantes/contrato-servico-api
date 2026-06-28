package com.contratoservicoapi.mapper;

import com.contratoservicoapi.dto.MedicaoRequestDTO;
import com.contratoservicoapi.dto.MedicaoResponseDTO;
import com.contratoservicoapi.model.Medicao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicaoMapper {

    @Mapping(target = "contrato", ignore = true)
    Medicao toEntity(MedicaoRequestDTO dto);

    @Mapping(target = "contratoId", source = "contrato.id")
    MedicaoResponseDTO toResponseDTO(Medicao entity);
}

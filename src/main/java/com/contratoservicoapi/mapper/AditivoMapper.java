package com.contratoservicoapi.mapper;

import com.contratoservicoapi.dto.AditivoRequestDTO;
import com.contratoservicoapi.dto.AditivoResponseDTO;
import com.contratoservicoapi.model.Aditivo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AditivoMapper {

    @Mapping(target = "contrato", ignore = true)
    Aditivo toEntity(AditivoRequestDTO dto);

    @Mapping(target = "contratoId", source = "contrato.id")
    AditivoResponseDTO toResponseDTO(Aditivo entity);
}

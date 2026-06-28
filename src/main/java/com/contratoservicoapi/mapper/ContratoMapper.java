package com.contratoservicoapi.mapper;

import com.contratoservicoapi.dto.ContratoRequestDTO;
import com.contratoservicoapi.dto.ContratoResponseDTO;
import com.contratoservicoapi.model.Contrato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContratoMapper {

    @Mapping(target = "fornecedor", ignore = true)
    Contrato toEntity(ContratoRequestDTO dto);

    @Mapping(target = "fornecedorId", source = "fornecedor.id")
    ContratoResponseDTO toResponseDTO(Contrato entity);
}

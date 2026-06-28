package com.contratoservicoapi.mapper;

import com.contratoservicoapi.dto.FornecedorRequestDTO;
import com.contratoservicoapi.dto.FornecedorResponseDTO;
import com.contratoservicoapi.model.Fornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FornecedorMapper {

    Fornecedor toEntity(FornecedorRequestDTO dto);

    FornecedorResponseDTO toResponseDTO(Fornecedor entity);
}

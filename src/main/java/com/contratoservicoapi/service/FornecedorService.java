package com.contratoservicoapi.service;

import com.contratoservicoapi.dto.FornecedorRequestDTO;
import com.contratoservicoapi.dto.FornecedorResponseDTO;
import com.contratoservicoapi.exception.ResourceNotFoundException;
import com.contratoservicoapi.mapper.FornecedorMapper;
import com.contratoservicoapi.model.Fornecedor;
import com.contratoservicoapi.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private FornecedorMapper mapper;

    @Transactional(readOnly = true)
    public List<FornecedorResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FornecedorResponseDTO buscar(Long id) {
        Fornecedor entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public FornecedorResponseDTO criar(FornecedorRequestDTO dto) {
        Fornecedor entity = mapper.toEntity(dto);
        Fornecedor salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public FornecedorResponseDTO atualizar(Long id, FornecedorRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Fornecedor não encontrado com id: " + id);
        }
        Fornecedor entity = mapper.toEntity(dto);
        entity.setId(id);
        Fornecedor salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Fornecedor não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}

package com.contratoservicoapi.service;

import com.contratoservicoapi.dto.ContratoRequestDTO;
import com.contratoservicoapi.dto.ContratoResponseDTO;
import com.contratoservicoapi.exception.ResourceNotFoundException;
import com.contratoservicoapi.mapper.ContratoMapper;
import com.contratoservicoapi.model.Contrato;
import com.contratoservicoapi.repository.ContratoRepository;
import com.contratoservicoapi.repository.FornecedorRepository;
import com.contratoservicoapi.model.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContratoService {

    @Autowired
    private ContratoRepository repository;

    @Autowired
    private ContratoMapper mapper;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Transactional(readOnly = true)
    public List<ContratoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ContratoResponseDTO buscar(Long id) {
        Contrato entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ContratoResponseDTO criar(ContratoRequestDTO dto) {
        Contrato entity = mapper.toEntity(dto);
        Fornecedor fornecedor = fornecedorRepository.findById(dto.getFornecedorId())
            .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado com id: " + dto.getFornecedorId()));
        entity.setFornecedor(fornecedor);
        Contrato salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ContratoResponseDTO atualizar(Long id, ContratoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Contrato não encontrado com id: " + id);
        }
        Contrato entity = mapper.toEntity(dto);
        entity.setId(id);
        Fornecedor fornecedor = fornecedorRepository.findById(dto.getFornecedorId())
            .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado com id: " + dto.getFornecedorId()));
        entity.setFornecedor(fornecedor);
        Contrato salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Contrato não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}

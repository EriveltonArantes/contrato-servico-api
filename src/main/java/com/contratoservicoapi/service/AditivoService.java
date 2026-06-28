package com.contratoservicoapi.service;

import com.contratoservicoapi.dto.AditivoRequestDTO;
import com.contratoservicoapi.dto.AditivoResponseDTO;
import com.contratoservicoapi.exception.ResourceNotFoundException;
import com.contratoservicoapi.mapper.AditivoMapper;
import com.contratoservicoapi.model.Aditivo;
import com.contratoservicoapi.repository.AditivoRepository;
import com.contratoservicoapi.repository.ContratoRepository;
import com.contratoservicoapi.model.Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AditivoService {

    @Autowired
    private AditivoRepository repository;

    @Autowired
    private AditivoMapper mapper;

    @Autowired
    private ContratoRepository contratoRepository;

    @Transactional(readOnly = true)
    public List<AditivoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AditivoResponseDTO buscar(Long id) {
        Aditivo entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Aditivo não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public AditivoResponseDTO criar(AditivoRequestDTO dto) {
        Aditivo entity = mapper.toEntity(dto);
        Contrato contrato = contratoRepository.findById(dto.getContratoId())
            .orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado com id: " + dto.getContratoId()));
        entity.setContrato(contrato);
        Aditivo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public AditivoResponseDTO atualizar(Long id, AditivoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Aditivo não encontrado com id: " + id);
        }
        Aditivo entity = mapper.toEntity(dto);
        entity.setId(id);
        Contrato contrato = contratoRepository.findById(dto.getContratoId())
            .orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado com id: " + dto.getContratoId()));
        entity.setContrato(contrato);
        Aditivo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Aditivo não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}

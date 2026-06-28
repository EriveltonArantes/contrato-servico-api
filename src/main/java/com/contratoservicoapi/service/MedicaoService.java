package com.contratoservicoapi.service;

import com.contratoservicoapi.dto.MedicaoRequestDTO;
import com.contratoservicoapi.dto.MedicaoResponseDTO;
import com.contratoservicoapi.exception.ResourceNotFoundException;
import com.contratoservicoapi.mapper.MedicaoMapper;
import com.contratoservicoapi.model.Medicao;
import com.contratoservicoapi.repository.MedicaoRepository;
import com.contratoservicoapi.repository.ContratoRepository;
import com.contratoservicoapi.model.Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MedicaoService {

    @Autowired
    private MedicaoRepository repository;

    @Autowired
    private MedicaoMapper mapper;

    @Autowired
    private ContratoRepository contratoRepository;

    @Transactional(readOnly = true)
    public List<MedicaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MedicaoResponseDTO buscar(Long id) {
        Medicao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Medicao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public MedicaoResponseDTO criar(MedicaoRequestDTO dto) {
        Medicao entity = mapper.toEntity(dto);
        Contrato contrato = contratoRepository.findById(dto.getContratoId())
            .orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado com id: " + dto.getContratoId()));
        entity.setContrato(contrato);
        Medicao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public MedicaoResponseDTO atualizar(Long id, MedicaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Medicao não encontrado com id: " + id);
        }
        Medicao entity = mapper.toEntity(dto);
        entity.setId(id);
        Contrato contrato = contratoRepository.findById(dto.getContratoId())
            .orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado com id: " + dto.getContratoId()));
        entity.setContrato(contrato);
        Medicao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Medicao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}

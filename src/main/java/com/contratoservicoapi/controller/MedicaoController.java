package com.contratoservicoapi.controller;

import com.contratoservicoapi.dto.MedicaoRequestDTO;
import com.contratoservicoapi.dto.MedicaoResponseDTO;
import com.contratoservicoapi.service.MedicaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Medicao", description = "Gerenciamento de medicaos")
@RestController
@RequestMapping("/api/medicaos")
public class MedicaoController {

    @Autowired
    private MedicaoService service;

    @Operation(summary = "Listar todos os Medicao")
    @GetMapping
    public List<MedicaoResponseDTO> listar(@RequestParam(required = false) String periodo, @RequestParam(required = false) Long contratoId) {
        List<MedicaoResponseDTO> resultado = service.listar();
        if (periodo != null && !periodo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getPeriodo() != null &&
                item.getPeriodo().toLowerCase().contains(periodo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (contratoId != null) {
            resultado = resultado.stream().filter(item -> contratoId.equals(item.getContratoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Medicao por ID")
    @GetMapping("/{id}")
    public MedicaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Medicao")
    @PostMapping
    public ResponseEntity<MedicaoResponseDTO> criar(@Valid @RequestBody MedicaoRequestDTO medicao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(medicao));
    }

    @Operation(summary = "Atualizar Medicao")
    @PutMapping("/{id}")
    public MedicaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody MedicaoRequestDTO medicao) {
        return service.atualizar(id, medicao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Medicao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

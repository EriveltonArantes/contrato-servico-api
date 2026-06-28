package com.contratoservicoapi.controller;

import com.contratoservicoapi.dto.AditivoRequestDTO;
import com.contratoservicoapi.dto.AditivoResponseDTO;
import com.contratoservicoapi.service.AditivoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Aditivo", description = "Gerenciamento de aditivos")
@RestController
@RequestMapping("/api/aditivos")
public class AditivoController {

    @Autowired
    private AditivoService service;

    @Operation(summary = "Listar todos os Aditivo")
    @GetMapping
    public List<AditivoResponseDTO> listar(@RequestParam(required = false) String tipo, @RequestParam(required = false) Long contratoId) {
        List<AditivoResponseDTO> resultado = service.listar();
        if (tipo != null && !tipo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTipo() != null &&
                item.getTipo().toLowerCase().contains(tipo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (contratoId != null) {
            resultado = resultado.stream().filter(item -> contratoId.equals(item.getContratoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Aditivo por ID")
    @GetMapping("/{id}")
    public AditivoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Aditivo")
    @PostMapping
    public ResponseEntity<AditivoResponseDTO> criar(@Valid @RequestBody AditivoRequestDTO aditivo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(aditivo));
    }

    @Operation(summary = "Atualizar Aditivo")
    @PutMapping("/{id}")
    public AditivoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody AditivoRequestDTO aditivo) {
        return service.atualizar(id, aditivo);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Aditivo")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

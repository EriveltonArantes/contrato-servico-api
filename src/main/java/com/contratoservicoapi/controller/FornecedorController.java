package com.contratoservicoapi.controller;

import com.contratoservicoapi.dto.FornecedorRequestDTO;
import com.contratoservicoapi.dto.FornecedorResponseDTO;
import com.contratoservicoapi.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Fornecedor", description = "Gerenciamento de fornecedors")
@RestController
@RequestMapping("/api/fornecedors")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @Operation(summary = "Listar todos os Fornecedor")
    @GetMapping
    public List<FornecedorResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<FornecedorResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Fornecedor por ID")
    @GetMapping("/{id}")
    public FornecedorResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Fornecedor")
    @PostMapping
    public ResponseEntity<FornecedorResponseDTO> criar(@Valid @RequestBody FornecedorRequestDTO fornecedor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(fornecedor));
    }

    @Operation(summary = "Atualizar Fornecedor")
    @PutMapping("/{id}")
    public FornecedorResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody FornecedorRequestDTO fornecedor) {
        return service.atualizar(id, fornecedor);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Fornecedor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

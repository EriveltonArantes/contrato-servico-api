package com.contratoservicoapi.controller;

import com.contratoservicoapi.model.Fornecedor;
import com.contratoservicoapi.model.Contrato;
import com.contratoservicoapi.model.Medicao;
import com.contratoservicoapi.model.Aditivo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.contratoservicoapi.repository.FornecedorRepository fornecedorRepository;

    @Autowired
    private com.contratoservicoapi.repository.ContratoRepository contratoRepository;

    @Autowired
    private com.contratoservicoapi.repository.MedicaoRepository medicaoRepository;

    @Autowired
    private com.contratoservicoapi.repository.AditivoRepository aditivoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalFornecedor", fornecedorRepository.count());
        resumo.put("somaAvaliacaoFornecedor", fornecedorRepository.findAll().stream().filter(e -> e.getAvaliacao() != null).mapToDouble(e -> e.getAvaliacao()).sum());
        resumo.put("totalContrato", contratoRepository.count());
        resumo.put("somaValorContrato", contratoRepository.findAll().stream().map(e -> e.getValor()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoContrato", contratoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalMedicao", medicaoRepository.count());
        resumo.put("somaQuantidadeExecutadaMedicao", medicaoRepository.findAll().stream().filter(e -> e.getQuantidadeExecutada() != null).mapToInt(e -> e.getQuantidadeExecutada()).sum());
        resumo.put("graficoMedicao", medicaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalAditivo", aditivoRepository.count());
        resumo.put("somaValorAditivo", aditivoRepository.findAll().stream().map(e -> e.getValor()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoAditivo", aditivoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}

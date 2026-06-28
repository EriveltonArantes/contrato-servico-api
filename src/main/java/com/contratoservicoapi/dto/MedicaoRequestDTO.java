package com.contratoservicoapi.dto;

import jakarta.validation.constraints.*;

public class MedicaoRequestDTO {

    @NotNull(message = "ContratoId é obrigatório")
    @Positive(message = "ContratoId deve ser um ID válido (positivo)")
    private Long contratoId;
    @NotBlank(message = "periodo não pode estar em branco")
    private String periodo;
    @Min(value = 0, message = "quantidade executada não pode ser negativo")
    @NotNull(message = "quantidade executada não pode ser nulo")
    private Integer quantidadeExecutada;
    @DecimalMin(value = "0.0", message = "valor medicao não pode ser negativo")
    @NotNull(message = "valor medicao não pode ser nulo")
    private Double valorMedicao;
    @NotNull(message = "data envio não pode ser nulo")
    private java.time.LocalDateTime dataEnvio;
    @NotNull(message = "data aprovacao não pode ser nulo")
    private java.time.LocalDateTime dataAprovacao;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getContratoId() { return contratoId; }
    public void setContratoId(Long contratoId) { this.contratoId = contratoId; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    public Integer getQuantidadeExecutada() { return quantidadeExecutada; }
    public void setQuantidadeExecutada(Integer quantidadeExecutada) { this.quantidadeExecutada = quantidadeExecutada; }
    public Double getValorMedicao() { return valorMedicao; }
    public void setValorMedicao(Double valorMedicao) { this.valorMedicao = valorMedicao; }
    public java.time.LocalDateTime getDataEnvio() { return dataEnvio; }
    public void setDataEnvio(java.time.LocalDateTime dataEnvio) { this.dataEnvio = dataEnvio; }
    public java.time.LocalDateTime getDataAprovacao() { return dataAprovacao; }
    public void setDataAprovacao(java.time.LocalDateTime dataAprovacao) { this.dataAprovacao = dataAprovacao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

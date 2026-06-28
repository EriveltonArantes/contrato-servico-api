package com.contratoservicoapi.dto;

public class MedicaoResponseDTO {

    private Long id;
    private Long contratoId;
    private String periodo;
    private Integer quantidadeExecutada;
    private Double valorMedicao;
    private java.time.LocalDateTime dataEnvio;
    private java.time.LocalDateTime dataAprovacao;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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

package com.contratoservicoapi.dto;

import jakarta.validation.constraints.*;

public class ContratoRequestDTO {

    @NotNull(message = "FornecedorId é obrigatório")
    @Positive(message = "FornecedorId deve ser um ID válido (positivo)")
    private Long fornecedorId;
    @NotBlank(message = "objeto não pode estar em branco")
    private String objeto;
    @DecimalMin(value = "0.0", message = "valor não pode ser negativo")
    @NotNull(message = "valor não pode ser nulo")
    private java.math.BigDecimal valor;
    @FutureOrPresent(message = "data inicio não pode ser retroativo")
    @NotNull(message = "data inicio não pode ser nulo")
    private java.time.LocalDateTime dataInicio;
    @FutureOrPresent(message = "data fim não pode ser retroativo")
    @NotNull(message = "data fim não pode ser nulo")
    private java.time.LocalDateTime dataFim;
    @NotNull(message = "garantia não pode ser nulo")
    private Boolean garantia;
    @NotNull(message = "fiscal não pode ser nulo")
    private Boolean fiscal;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getFornecedorId() { return fornecedorId; }
    public void setFornecedorId(Long fornecedorId) { this.fornecedorId = fornecedorId; }
    public String getObjeto() { return objeto; }
    public void setObjeto(String objeto) { this.objeto = objeto; }
    public java.math.BigDecimal getValor() { return valor; }
    public void setValor(java.math.BigDecimal valor) { this.valor = valor; }
    public java.time.LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(java.time.LocalDateTime dataInicio) { this.dataInicio = dataInicio; }
    public java.time.LocalDateTime getDataFim() { return dataFim; }
    public void setDataFim(java.time.LocalDateTime dataFim) { this.dataFim = dataFim; }
    public Boolean getGarantia() { return garantia; }
    public void setGarantia(Boolean garantia) { this.garantia = garantia; }
    public Boolean getFiscal() { return fiscal; }
    public void setFiscal(Boolean fiscal) { this.fiscal = fiscal; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

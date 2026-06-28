package com.contratoservicoapi.dto;

import jakarta.validation.constraints.*;

public class AditivoRequestDTO {

    @NotNull(message = "ContratoId é obrigatório")
    @Positive(message = "ContratoId deve ser um ID válido (positivo)")
    private Long contratoId;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "objeto não pode estar em branco")
    private String objeto;
    @DecimalMin(value = "0.0", message = "valor não pode ser negativo")
    @NotNull(message = "valor não pode ser nulo")
    private java.math.BigDecimal valor;
    @NotNull(message = "prazo não pode ser nulo")
    private java.time.LocalDateTime prazo;
    @NotBlank(message = "motivo não pode estar em branco")
    private String motivo;
    @NotNull(message = "data assinatura não pode ser nulo")
    private java.time.LocalDateTime dataAssinatura;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getContratoId() { return contratoId; }
    public void setContratoId(Long contratoId) { this.contratoId = contratoId; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getObjeto() { return objeto; }
    public void setObjeto(String objeto) { this.objeto = objeto; }
    public java.math.BigDecimal getValor() { return valor; }
    public void setValor(java.math.BigDecimal valor) { this.valor = valor; }
    public java.time.LocalDateTime getPrazo() { return prazo; }
    public void setPrazo(java.time.LocalDateTime prazo) { this.prazo = prazo; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public java.time.LocalDateTime getDataAssinatura() { return dataAssinatura; }
    public void setDataAssinatura(java.time.LocalDateTime dataAssinatura) { this.dataAssinatura = dataAssinatura; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

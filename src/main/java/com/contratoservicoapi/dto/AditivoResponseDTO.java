package com.contratoservicoapi.dto;

public class AditivoResponseDTO {

    private Long id;
    private Long contratoId;
    private String tipo;
    private String objeto;
    private java.math.BigDecimal valor;
    private java.time.LocalDateTime prazo;
    private String motivo;
    private java.time.LocalDateTime dataAssinatura;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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

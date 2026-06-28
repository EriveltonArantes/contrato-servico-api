package com.contratoservicoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    @Column(nullable = false)
    private String objeto;
    private java.math.BigDecimal valor;
    private java.time.LocalDateTime dataInicio;
    private java.time.LocalDateTime dataFim;
    private Boolean garantia;
    private Boolean fiscal;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Fornecedor getFornecedor() { return fornecedor; }
    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }
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

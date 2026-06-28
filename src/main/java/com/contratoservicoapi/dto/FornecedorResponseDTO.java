package com.contratoservicoapi.dto;

public class FornecedorResponseDTO {

    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String categoria;
    private Double avaliacao;
    private Boolean ativo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public Double getAvaliacao() { return avaliacao; }
    public void setAvaliacao(Double avaliacao) { this.avaliacao = avaliacao; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}

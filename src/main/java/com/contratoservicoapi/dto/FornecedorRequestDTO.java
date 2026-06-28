package com.contratoservicoapi.dto;

import jakarta.validation.constraints.*;

public class FornecedorRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cnpj não pode estar em branco")
    @Size(min = 14, max = 18, message = "cnpj deve ter entre 14 e 18 dígitos")
    private String cnpj;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "categoria não pode estar em branco")
    private String categoria;
    @NotNull(message = "avaliacao não pode ser nulo")
    private Double avaliacao;
    @NotNull(message = "ativo não pode ser nulo")
    private Boolean ativo;

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

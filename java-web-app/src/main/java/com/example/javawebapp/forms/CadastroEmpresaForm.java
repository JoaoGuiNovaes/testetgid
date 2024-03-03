package com.example.javawebapp.forms;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CadastroEmpresaForm {

//Validação de não nulidade + CNPJ usando Bean Validation

    @NotBlank
    @NotNull
    /*/@CNPJ/*/
    private String cnpj;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 30)
    private String senha;
    
    @NotNull
    private Double Taxa;

    public CadastroEmpresaForm(@NotBlank @NotNull String cnpj, @NotNull @NotBlank String nome,
            @NotNull @NotBlank @Size(min = 4, max = 30) String senha, @NotNull Double taxa) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.senha = senha;
        Taxa = taxa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getTaxa() {
        return Taxa;
    }

    public void setTaxa(Double taxa) {
        Taxa = taxa;
    }
}
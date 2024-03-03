package com.example.javawebapp.empresa;

public class Empresa {

    private Integer id;
    private String cnpj;
    private String nome;
    private String senha;
    private Double saldo;
    private Double taxa;

    public Empresa(Integer id, String cnpj, String nome, String senha, Double saldo, Double taxa) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.senha = senha;
        this.saldo = saldo;
        this.taxa = taxa;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public Double getTaxa() {
        return taxa;
    }
    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }
    
    
}

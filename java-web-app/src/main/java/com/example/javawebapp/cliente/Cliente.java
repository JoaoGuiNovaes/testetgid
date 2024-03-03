package com.example.javawebapp.cliente;

public class Cliente {
    private Integer id;
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String cnpjEmpresa;

    public Cliente(Integer id, String cpf, String nome, String email, String senha, String cnpjEmpresa) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public Cliente(Integer id, String cpf, String nome, String email, String senha) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getId_empresa() {
        return cnpjEmpresa;
    }
    public void setId_empresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    

    
}

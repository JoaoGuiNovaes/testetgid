package com.example.javawebapp.forms;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CadastroForm {

    //Validação de não nulidade + CPF usando Bean Validation

    @NotNull
    @NotBlank
    @CPF
    private String cpf;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 30)
    private String senha;

    public CadastroForm(@NotNull @NotBlank @CPF String cpf, @NotNull @NotBlank String nome,
            @NotNull @NotBlank @Email String email, @NotNull @NotBlank @Size(min = 4, max = 30) String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

}
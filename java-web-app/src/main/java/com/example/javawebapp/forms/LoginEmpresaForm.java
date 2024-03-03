package com.example.javawebapp.forms;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginEmpresaForm {

//Validação de não nulidade + CNPJ usando Bean Validation

    @NotNull
    @NotBlank
    /* @CNPJ*/ 
    private String cnpj;
    @NotNull
    @NotEmpty
    @Size(min = 4, max = 30)
    private String senha;

    public LoginEmpresaForm(@NotNull @NotBlank String cnpj,
            @NotNull @NotEmpty @Size(min = 4, max = 30) String senha) {
        this.cnpj = cnpj;
        this.senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

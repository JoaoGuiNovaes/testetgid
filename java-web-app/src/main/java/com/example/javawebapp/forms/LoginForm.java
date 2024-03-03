package com.example.javawebapp.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginForm {

    //Validação de não nulidade + email usando Bean Validation

    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotEmpty
    @Size(min = 4, max = 30)
    private String senha;
        
    public LoginForm(String email, String senha) {
        this.email = email;
        this.senha = senha;
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

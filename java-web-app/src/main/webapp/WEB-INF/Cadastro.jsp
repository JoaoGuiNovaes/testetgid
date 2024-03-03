<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Anton&family=Pangolin&display=swap"
        rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
        crossorigin="anonymous">
    <link rel="stylesheet" href="styles/cadastro.css">

    <title>
        <fmt:message key="registration.title" />
    </title>
</head>

<body>
    <main>
        <div class="direita">
            <div class="card container mt-5">
                <h1>
                    <fmt:message key="registration.title" />
                </h1>
                <c:if test="${violations != null}">
                    <h3>
                        <fmt:message key="registration.message" />
                        </h2>
                        <ul>
                            <c:forEach var="violation" items="${violations}">
                                <li>${violation.message}</li>
                            </c:forEach>
                        </ul>
                </c:if>
                <c:if test="${existeErro != null}">
                    <h4>${existeErro}</h4>
                </c:if>
                <form class="needs-validation" action="Cadastro" method="post" novalidate id="form1" >
                    <input type="hidden" id="id_empresa" name="id_empresa" value="${empresa.id}" >
                    <label for="cpf" class="form-label"><fmt:message key="registration.cpf" /></label>
                    <div class="input-group">
                        <input type="text" id="cpf" name="cpf" class="form-control"
                            placeholder="Digite seu cpf" value="${cadastroForm.cpf}">
                            <div class="invalid-feedback">
                                Preencha este campo!
                              </div>
                    </div>
                    <label for="nome" class="form-label"><fmt:message key="registration.name" /></label>
                    <div class="input-group">
                        <input type="text" id="nome" name="nome" class="form-control"
                            placeholder="Digite seu nome" value="${cadastroForm.nome}">
                            <div class="invalid-feedback">
                                Preencha este campo!
                              </div>
                    </div>
                    <label for="email" class="form-label"><fmt:message key="registration.email" /></label>
                    <div class="input-group">
                        <input type="email" id="email" name="email" class="form-control"
                            placeholder="Digite seu E-mail" value="${cadastroForm.email}">
                            <div class="invalid-feedback">
                                Insira um formato de e-mail válido!
                              </div>
                    </div>
                    <label for="senha" class="form-label"><fmt:message key="registration.password" /></label>
                    <div class="input-group">
                        <input type="password" id="senha" name="senha" class="form-control"
                            placeholder="Digite sua senha" value="${cadastroForm.senha}">
                            <div class="invalid-feedback">
                                Senha deve ter entre 4 e 30 caracteres, pelo menos um caractere maiúsculo, um minúsculo, e um número!
                              </div>
                    </div>
                    <div class="divbutton">
                        <button type="submit" class="btn btn-dark"><fmt:message key="registration.buttonRegister" /></button>
                        <div class="aindanao">
                            <strong class="ainda"><fmt:message key="registration.login" /></strong>
                            <a href="Login"><button type="button" class="btn btn-light criar eita"><fmt:message key="registration.loginButton" /></button></a> 
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </main>
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"></script>
    <script src="scripts/scriptCadastro.js"></script>
</body>
</html>
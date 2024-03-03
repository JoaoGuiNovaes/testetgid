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
                <link rel="stylesheet" href="styles/loginEmpresa.css">

                <title>
                    <fmt:message key="loginEmpresa.title" />
                </title>
            </head>

            <body>
                <main>
                    <div class="direita">
                        <div class="card container mt-5">
                            <div class="container titulo">
                                <h1>
                                    <fmt:message key="loginEmpresa.title" />
                                </h1>
                            </div>
                            <p>${errorLoginEmpresa}</p>
                            <c:if test="${violations != null}">
                                <h3>
                                    <fmt:message key="loginEmpresa.message" />
                                    </h2>
                                    <ul>
                                        <c:forEach var="violation" items="${violations}">
                                            <li>${violation.message}</li>
                                        </c:forEach>
                                    </ul>
                            </c:if>
                            <form action="LoginEmpresa" method="post">
                                  <input type="hidden" id="id_endereco" name="id_endereco"  value="${endereco.id}" >
                                <label for="cnpj" class="form-label">
                                   CNPJ
                                </label>
                                <div class="input-group">
                                    <input type="text" id="cnpj" name="cnpj" class="form-control"
                                        placeholder="Digite seu cnpj" value="${cnpj}">
                                </div>
                                <label for="senha" class="form-label">
                                    <fmt:message key="loginEmpresa.password" />
                                </label>
                                <div class="input-group">
                                    <input type="password" id="senha" name="senha" class="form-control"
                                        placeholder="Digite sua senha" value="${senha}">
                                </div>
                                <div class="divbutton">
                                    <button type="submit" class="btn btn-dark">
                                        <fmt:message key="loginEmpresa.button" />
                                    </button>
                                </div>
                                <div class="aindanao">
                                    <strong class="ainda">
                                        <fmt:message key="loginEmpresa.notAccount" />
                                    </strong>
                                    <a href="CadastroEmpresa"><button type="button" class="btn btn-dark criar">
                                            <fmt:message key="loginEmpresa.buttonCreateAccount" />
                                        </button></a>
                                </div>
                            </form>
                        </div>
                    </div>
                </main>
            </body>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
                crossorigin="anonymous"></script>
            <script src="scripts/scriptLoginEmpresa.js"></script>
            </body>
            </html>
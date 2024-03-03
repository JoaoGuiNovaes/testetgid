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
                <link rel="stylesheet" href="styles/transacao.css">

                <title>
                    Transacao
                </title>
            </head>

            <body>
                <main>
                    <div class="direita">
                        <div class="card container mt-5">
                            <div class="container titulo">
                                <h1>
                                    Transacao
                                </h1>
                            </div>
                            <form action="Transacao" method="post">
                                <label for="tipo" class="form-label">
                                   Tipo transação
                                </label>
                                <div class="input-group">
                                    <input type="text" id="tipo" name="tipo" class="form-control"
                                        placeholder="Saque ou depósito" value="${cnpj}">
                                </div>
                                <label for="valor" class="form-label">
                                    Valor
                                </label>
                                <div class="input-group">
                                    <input type="text" id="valor" name="valor" class="form-control"
                                        placeholder="Valor" value="${valor}">
                                </div>
                                <div class="divbutton">
                                    <button type="submit" class="btn btn-dark">
                                        Submit
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </main>
            </body>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
                crossorigin="anonymous"></script>
            </body>
            </html>
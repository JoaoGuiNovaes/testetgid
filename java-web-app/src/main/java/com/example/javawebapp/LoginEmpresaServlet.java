package com.example.javawebapp;

import java.io.IOException;
import java.util.Set;

import com.example.javawebapp.empresa.EmpresaDAO;
import com.example.javawebapp.forms.LoginEmpresaForm;
import com.example.javawebapp.validators.ValidatorUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;

@WebServlet(name = "loginEmpresaServlet", value = "/LoginEmpresa")
public class LoginEmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/LoginEmpresa.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String cnpj = req.getParameter("cnpj");
        String senha = req.getParameter("senha");

        LoginEmpresaForm loginEmpresaForm = new LoginEmpresaForm(cnpj, senha);

        Set<ConstraintViolation<LoginEmpresaForm>> violations = 
            ValidatorUtil.validateObject(loginEmpresaForm);

            if (violations.isEmpty()) {
                if (EmpresaDAO.login(cnpj, senha)) {
                    HttpSession session = req.getSession();
                    session.setAttribute("cnpjEmpresa", cnpj);
                    req.getRequestDispatcher("WEB-INF/Login.jsp").forward(req, res);
                } else {
                    req.setAttribute("errorLogin", "CNPJ ou senha incorretos");
                    req.getRequestDispatcher("WEB-INF/LoginEmpresa.jsp").forward(req, res);
                }
            } else {
                req.setAttribute("cnpj", cnpj);
                req.setAttribute("senha", senha);
                req.setAttribute("violations", violations);
                req.getRequestDispatcher("WEB-INF/LoginEmpresa.jsp").forward(req, res);
            }
}
}
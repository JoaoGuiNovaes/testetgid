package com.example.javawebapp;

import java.io.IOException;
import java.util.Set;

import com.example.javawebapp.empresa.EmpresaDAO;
import com.example.javawebapp.forms.CadastroEmpresaForm;
import com.example.javawebapp.validators.ValidatorUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;

@WebServlet(name = "cadastroEmpresaServlet", value = "/CadastroEmpresa")
public class CadastroEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/CadastroEmpresa.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String cnpj = req.getParameter("cnpj");
        String nome = req.getParameter("nome");
        String taxa = req.getParameter("taxa");
        String senha = req.getParameter("senha");
        double taxadouble = Double.parseDouble(taxa);
       
        CadastroEmpresaForm cadastroEmpresaForm = new CadastroEmpresaForm(cnpj, nome, senha, taxadouble);
        
       Set<ConstraintViolation<CadastroEmpresaForm>> violations = ValidatorUtil.validateObject(cadastroEmpresaForm);
        
       if (violations.isEmpty()) {
           if (EmpresaDAO.existeComCnpj(cnpj)) {
               
                req.setAttribute("existeErro", "Já existe uma empresa com esse e-mail");
                req.getRequestDispatcher("WEB-INF/CadastroEmpresa.jsp").forward(req, res);
            } else {
                EmpresaDAO.cadastrar(cnpj, nome, senha, taxadouble);
               res.sendRedirect("LoginEmpresa");
           }
       } else {
           req.setAttribute("cadastroEmpresaForm", cadastroEmpresaForm);
           req.setAttribute("violations", violations);
           req.getRequestDispatcher("WEB-INF/CadastroEmpresa.jsp").forward(req, res);
        }

    }
}
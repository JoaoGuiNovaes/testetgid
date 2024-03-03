package com.example.javawebapp;

import java.io.IOException;
import com.example.javawebapp.empresa.EmpresaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "TransacaoServlet", value = "/Transacao")
public class Transacao extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/Transacao.jsp").forward(req, res);
    }

       protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String tipo = req.getParameter("tipo");
        String valor = req.getParameter("valor");
        double valordouble = Double.parseDouble(valor);
        HttpSession session = req.getSession();
        String cnpjEmpresa = (String) session.getAttribute("cnpjEmpresa");
        String emailUsuario = (String) session.getAttribute("emailUsuario");
        
        
        EmpresaDAO.processarTransacao(cnpjEmpresa, tipo, valordouble, emailUsuario);
    }
}
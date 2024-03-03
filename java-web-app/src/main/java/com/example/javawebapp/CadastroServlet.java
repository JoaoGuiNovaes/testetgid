package com.example.javawebapp;

import java.io.IOException;
import java.util.Set;

import com.example.javawebapp.cliente.Cliente;
import com.example.javawebapp.cliente.ClienteDao;
import com.example.javawebapp.empresa.EmpresaDAO;
import com.example.javawebapp.forms.CadastroForm;
import com.example.javawebapp.validators.ValidatorUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;

@WebServlet(name = "cadastroServlet", value = "/Cadastro")
public class CadastroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/Cadastro.jsp").forward(req, res);
        HttpSession session = req.getSession();
        String cnpjEmpresa = (String) session.getAttribute("cnpjEmpresa");
        Integer idEmpresaLogada = EmpresaDAO.buscarPorCnpj(cnpjEmpresa).getId();
        Cliente cliente = ClienteDao.buscarPorCnpjEmpresaCliente(idEmpresaLogada);
        req.setAttribute("empresa", cliente);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String nome = req.getParameter("nome");
        HttpSession session = req.getSession();
        String cnpjEmpresa = (String) session.getAttribute("cnpjEmpresa");
        System.out.println(cnpjEmpresa);

       CadastroForm cadastroForm = new CadastroForm(cpf, nome, email, senha);
        
       Set<ConstraintViolation<CadastroForm>> violations = ValidatorUtil.validateObject(cadastroForm);
        
       if (violations.isEmpty()) {
           if (ClienteDao.existeComEmail(email)) {
               req.setAttribute("existeErro", "Já existe um usuário com esse e-mail");
               req.getRequestDispatcher("WEB-INF/Cadastro.jsp").forward(req, res);
           } else {
            ClienteDao.cadastrar(cpf, nome, email, senha, cnpjEmpresa);
               res.sendRedirect("Login");
           }
       } else {
           req.setAttribute("cadastroForm", cadastroForm);
           req.setAttribute("violations", violations);
           req.getRequestDispatcher("WEB-INF/Cadastro.jsp").forward(req, res);
       }

    }
}
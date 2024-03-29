package com.example.javawebapp;

import java.io.IOException;
import java.util.Set;

import com.example.javawebapp.cliente.ClienteDao;
import com.example.javawebapp.forms.LoginForm;
import com.example.javawebapp.validators.ValidatorUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;

@WebServlet(name = "loginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/Login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        LoginForm loginForm = new LoginForm(email, senha);

        Set<ConstraintViolation<LoginForm>> violations = 
            ValidatorUtil.validateObject(loginForm);

            if (violations.isEmpty()) {
                if (ClienteDao.login(email, senha)) {
                    HttpSession session = req.getSession();
                    session.setAttribute("emailUsuario", email);
                    res.sendRedirect("Transacao");
                } else {
                    req.setAttribute("errorLogin", "E-mail ou senha incorretos");
                    req.getRequestDispatcher("WEB-INF/Login.jsp").forward(req, res);
                }
            } else {
                req.setAttribute("email", email);
                req.setAttribute("senha", senha);
                req.setAttribute("violations", violations);
                req.getRequestDispatcher("WEB-INF/Login.jsp").forward(req, res);
            }
}
}
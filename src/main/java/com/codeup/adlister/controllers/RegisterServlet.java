package com.codeup.adlister.controllers;
import java.awt.*;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import javafx.scene.control.Alert;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private Component frame;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");


        boolean inputErrors =
                        username.isEmpty()
                        || email.isEmpty()
                        || password.isEmpty()
                        || confirm_password.isEmpty()
                        || (!password.equals(confirm_password));

        if (inputErrors) {
            request.setAttribute("error", "All the values are required");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
            return;
        }
        String hash = Password.hash(password);
        User user = new User(username, email, hash);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }

}
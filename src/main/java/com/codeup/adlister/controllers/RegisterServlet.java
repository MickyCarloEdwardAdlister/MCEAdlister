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
import java.util.HashMap;

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
              request.getAttribute("user");
        String hash = Password.hash(password);
        boolean emptyInput =
                username.isEmpty()
                        || email.isEmpty()
                        || password.isEmpty()
                        || confirm_password.isEmpty()
                        || (!password.equals(confirm_password));


        HashMap<String,String> registerError = new HashMap<>();
        if (username.isEmpty()){
            registerError.put("username","username is empty");
        }else {
            request.setAttribute("username",username);

        }
        if (email.isEmpty()){
            registerError.put("email","email is empty");
        }else {
            request.setAttribute("email",email);

        }
        if (password.isEmpty()){
            registerError.put("password","password is empty");
        }
        if (confirm_password.isEmpty()){
            registerError.put("confirm_password","confirm password is empty");
        }



        if (emptyInput) {
            request.setAttribute("error", registerError);

            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
            return;
        }
//        request.setAttribute("error", registerError);

        User user = new User(username, email, hash);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }

}
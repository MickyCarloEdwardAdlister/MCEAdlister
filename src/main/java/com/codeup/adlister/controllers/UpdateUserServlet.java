package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/user/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/users/updateUser.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        HashMap<String, String> errors = new HashMap<>();
        String email = request.getParameter("email");
        if(email.isEmpty()){
            errors.put("email","An Email is required");
        }
        if(!errors.isEmpty()){
            request.setAttribute("errors", errors);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/users/updateUser.jsp").forward(request, response);
        }else{
            user.setEmail(email);
            DaoFactory.getUsersDao().updateProfile(user);
            response.sendRedirect("/profile");
        }

    }
}


package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // If the user is not logged in
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
        }

        request.setAttribute("categories", DaoFactory.getAdsDao().getCategories());
        request.setAttribute("user", user);

        request.setAttribute("ads", DaoFactory.getAdsDao().findByUsername(user.getId()));

        request.getRequestDispatcher("/WEB-INF/users/profile.jsp").forward(request, response);
    }

}



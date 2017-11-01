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

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", DaoFactory.getAdsDao().getCategories());
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        }else{
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");


        if (user == null) {
            response.sendRedirect("/login");

        }

        Ad ad = new Ad(user.getId(),
                request.getParameter("title"),
                request.getParameter("description")
        );
        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/profile");

    }

}


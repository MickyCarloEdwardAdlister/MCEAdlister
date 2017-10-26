package com.codeup.adlister.controllers;

//import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getSession().getAttribute("ad") != null) {
//            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
//        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        boolean validAttempt = !title.isEmpty() && !description.isEmpty();

        if (validAttempt) {
            response.sendRedirect("/ads");

        }
        if (!validAttempt) {
            response.sendRedirect("/ads/create");
        }
//request.getParameter("title");
//request.getParameter("description");
//response.sendRedirect("ads");
    }
}

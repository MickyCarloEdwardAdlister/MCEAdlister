package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", DaoFactory.getAdsDao().getCategories());
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");


        if (user == null) {
            response.sendRedirect("/login");

        }
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        request.setAttribute("title", title);

        HashMap<String, String> adInputError = new HashMap<>();


        if (title.isEmpty()) {
            adInputError.put("title", "Title is empty");

        } else {
            request.setAttribute("title", title);
        }
        if (description.isEmpty()) {
            adInputError.put("description", "Description is empty");

        } else {
            request.setAttribute("description", description);
        }
        request.setAttribute("adInputError", adInputError);

        if (title.isEmpty() || description.isEmpty()) {
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
            return;
        } else {

            // create a new ad using current user id
            Ad ad = new Ad(
                    user.getId(),
                    title,
                    description
            );

            Long newAd = DaoFactory.getAdsDao().insert(ad);
            request.setAttribute("newAd", newAd);

            response.sendRedirect("/profile");
        }

    }
}



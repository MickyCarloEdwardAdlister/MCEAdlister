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

@WebServlet(name = "UpdateServlet", urlPatterns = "/ads/update")
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Ad ad = DaoFactory.getAdsDao().findById(Long.parseLong(id));
        request.setAttribute("ad", ad);
        request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        HashMap<String, String> errors = new HashMap<>();

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String id = request.getParameter("id");

        Ad ad = DaoFactory.getAdsDao().findById(Long.parseLong(id));

//        if (user.getId() != ad.getUserId()) {
//            response.sendRedirect("/ads");
//        } else {
        if (title.isEmpty()) {
            errors.put("title", "Title is required");
        }

        if (description.isEmpty()) {
            errors.put("description", "Description is required");
        }

        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
        } else {
            ad.setTitle(title);
            ad.setDescription(description);
            DaoFactory.getAdsDao().update(ad);
            response.sendRedirect("/ads");
        }
//        }

    }
}

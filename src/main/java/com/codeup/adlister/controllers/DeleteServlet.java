package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")

public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boolean k =  DaoFactory.getAdsDao().adsDelete(Long.parseLong(id));
        response.sendRedirect("/profile");
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//       boolean k =  DaoFactory.getAdsDao().adsDelete(Long.parseLong(id));
//        if (k) {
//            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request,response);
//        } else{
//            response.sendRedirect("/ads");
//        }
//    }
}

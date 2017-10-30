package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
//        response.sendRedirect("/ads");
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        // add a method to your ads dao to find a single ad by its id

        // get the ad from the database using its id

        // need to change the properties of the ad, using the values from the request
        // the values in the request represent the new values for the ad

     //   DaoFactory.getAdsDao().update(ad);
        if(request.getHeader("new enter").contains("updated")){
            response.sendRedirect("/ads");
        } else {
            response.sendRedirect(request.getHeader("Referer"));
        }


    }
}

package com.codeup.adlister.controllers;

import com.codeup.adlister.util.Password;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
 public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getSession().getAttribute("user") != null) {
//            response.sendRedirect("/profile");
//            return;
//        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean emptyInput = username.isEmpty() && password.isEmpty();

//              User user = DaoFactory.getUsersDao().findByUsername(username);

        if (emptyInput) {

            // start a session with the key user, asi n the other example

//           request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("user", username);
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);

        }
    }
}
//                boolean passwordsMatch = Password.check(password, user.getPassword());
//
//                if (passwordsMatch) {
//                    request.getSession().setAttribute("user", user);
//                    response.sendRedirect("/profile");
//                } else {
//                    response.sendRedirect("/login");
//                }
//            }
//        }

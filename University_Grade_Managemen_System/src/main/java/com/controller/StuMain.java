package com.controller;

import com.model.Students;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StuMain", value = "/StuMain")
public class StuMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Students students=(Students) request.getSession().getAttribute("students");
        request.getSession().setAttribute("students",students);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuMain.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

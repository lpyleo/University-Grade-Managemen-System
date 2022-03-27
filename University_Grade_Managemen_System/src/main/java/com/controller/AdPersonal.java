package com.controller;

import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdPersonal", value = "/AdPersonal")
public class AdPersonal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        request.getSession().setAttribute("teachers",teachers);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/adPersonal.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

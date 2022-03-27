package com.controller;

import com.model.Courses;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ClassCourseChange", value = "/ClassCourseChange")
public class ClassCourseChange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        String classno=request.getParameter("classno");
        String classname=request.getParameter("classname");
        String courseno=request.getParameter("courseno");
        String coursename=request.getParameter("coursename");
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("classno",classno);
        request.getSession().setAttribute("classname",classname);
        request.getSession().setAttribute("courseno",courseno);
        request.getSession().setAttribute("coursename",coursename);
        RequestDispatcher rd= request.getRequestDispatcher("/classCourseChange.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.Courses;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangeClassCourse", value = "/ChangeClassCourse")
public class ChangeClassCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        String classno=request.getParameter("classno");
        String classname=request.getParameter("classname");
        String courseno=request.getParameter("courseno");
        String coursename=request.getParameter("coursename");
        String classno9= (String) request.getSession().getAttribute("classno9");
        String classname9= (String) request.getSession().getAttribute("classname9");
        String courseno9= (String) request.getSession().getAttribute("courseno9");
        String coursename9= (String) request.getSession().getAttribute("coursename9");
        UsersDao dao=new UsersDaoImpl();
        try {
            if(dao.changeClassCourseInfo(courseno9,classno9,courseno,classno)){
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/ClassCourseManagement");
                rd.forward(request,response);
            }else {
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/ClassCourseManagement");
                rd.forward(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

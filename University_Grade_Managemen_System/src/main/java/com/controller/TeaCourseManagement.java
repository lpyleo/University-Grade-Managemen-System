package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.Courses;
import com.model.StuInfo;
import com.model.TeaCourse;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TeaCourseManagement", value = "/TeaCourseManagement")
public class TeaCourseManagement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        ArrayList<Courses> courses=new ArrayList<Courses>();
        UsersDao dao=new UsersDaoImpl();
        try {
            courses=dao.allCourse();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("courses",courses);
        RequestDispatcher rd= request.getRequestDispatcher("/teaCourseManagement.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

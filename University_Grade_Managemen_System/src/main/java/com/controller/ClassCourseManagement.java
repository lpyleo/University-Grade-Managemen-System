package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.AvgScore;
import com.model.ClassCourse;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ClassCourseManagement", value = "/ClassCourseManagement")
public class ClassCourseManagement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        ArrayList<ClassCourse> classCourses=new ArrayList<ClassCourse>();
        UsersDao dao=new UsersDaoImpl();
        try {
            classCourses=dao.allClassCourse();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("classCourses",classCourses);
        RequestDispatcher rd= request.getRequestDispatcher("/classCourseManagement.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

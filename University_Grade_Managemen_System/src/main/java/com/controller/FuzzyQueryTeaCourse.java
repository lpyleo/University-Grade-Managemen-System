package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.Courses;
import com.model.Students;
import com.model.TeaCourse;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FuzzyQueryTeaCourse", value = "/FuzzyQueryTeaCourse")
public class FuzzyQueryTeaCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String info=request.getParameter("info");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        ArrayList<Courses> courses=new ArrayList<Courses>();
        UsersDao dao=new UsersDaoImpl();
        try {
            courses=dao.findByFuzzyCourse(info);
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("courses",courses);
            RequestDispatcher rd= request.getRequestDispatcher("/teaCourseManagement.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

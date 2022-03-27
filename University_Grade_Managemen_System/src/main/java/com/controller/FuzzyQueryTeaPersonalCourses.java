package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.TeaCourse;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FuzzyQueryTeaPersonalCourses", value = "/FuzzyQueryTeaPersonalCourses")
public class FuzzyQueryTeaPersonalCourses extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String info=request.getParameter("info");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        ArrayList<TeaCourse> teaCourses=new ArrayList<TeaCourse>();
        UsersDao dao=new UsersDaoImpl();
        try {
            teaCourses=dao.findByFuzzyTeaCourse(info,teachers.getLpy_Tno15());
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("teaCourses",teaCourses);
            RequestDispatcher rd= request.getRequestDispatcher("/teaCourseInfo.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

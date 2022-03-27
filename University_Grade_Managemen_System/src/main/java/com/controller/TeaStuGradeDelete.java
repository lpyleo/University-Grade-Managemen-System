package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TeaStuGradeDelete", value = "/TeaStuGradeDelete")
public class TeaStuGradeDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        String no=request.getParameter("no");
        String coursename=request.getParameter("name");
        UsersDao dao=new UsersDaoImpl();
        String courseno= null;
        try {
            courseno = dao.queryCoursenoByName(coursename);
            dao.deleteGradeBySnoAndCourseno(no,courseno);
            dao.updateGPA();
            request.getSession().setAttribute("teachers",teachers);
            RequestDispatcher rd= request.getRequestDispatcher("/TeaStuGrade");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.StuGradeInfo;
import com.model.StuRank;
import com.model.Students;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StuGPA", value = "/StuGPA")
public class StuGPA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Students students=(Students) request.getSession().getAttribute("students");
        StuRank stuRank=new StuRank();
        UsersDao dao=new UsersDaoImpl();
        try {
            stuRank=dao.findOneRank(students.getLpy_Sno15());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("students",students);
        request.getSession().setAttribute("stuRank",stuRank);
        RequestDispatcher rd= request.getRequestDispatcher("/stuGPA.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
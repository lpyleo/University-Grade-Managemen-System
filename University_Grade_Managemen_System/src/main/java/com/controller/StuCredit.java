package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.StuRank;
import com.model.Students;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StuCredit", value = "/StuCredit")
public class StuCredit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Students students=(Students) request.getSession().getAttribute("students");
        Students students1=new Students();
        UsersDao dao=new UsersDaoImpl();
        try {
            students1=dao.findOneCredit(students.getLpy_Sno15());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("students",students);
        request.getSession().setAttribute("students1",students1);
        RequestDispatcher rd= request.getRequestDispatcher("/stuCredit.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.StuRank;
import com.model.Students;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FuzzyQueryStuCredit", value = "/FuzzyQueryStuCredit")
public class FuzzyQueryStuCredit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String info=request.getParameter("info");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        ArrayList<Students> students=new ArrayList<Students>();
        UsersDao dao=new UsersDaoImpl();
        try {
            students=dao.findByFuzzyStu(info);
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("students",students);
            RequestDispatcher rd= request.getRequestDispatcher("/stuCreditManagement.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

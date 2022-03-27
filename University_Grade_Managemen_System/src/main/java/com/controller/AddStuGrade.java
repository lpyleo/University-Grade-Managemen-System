package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddStuGrade", value = "/AddStuGrade")
public class AddStuGrade extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        String sno=request.getParameter("no");
        String courseno=request.getParameter("courseno");
        Double grade=Double.parseDouble(request.getParameter("grade"));
        UsersDao dao=new UsersDaoImpl();
        try {
            if(dao.addStuGrade(sno,courseno,grade)){
                dao.updateGPA();
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= request.getRequestDispatcher("/TeaStuGrade");
                rd.forward(request,response);
            }else {
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= request.getRequestDispatcher("/TeaStuGrade");
                rd.forward(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.StuGradeInfo;
import com.model.StuInfo;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TeaStuGradeChange", value = "/TeaStuGradeChange")
public class TeaStuGradeChange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        String no=request.getParameter("no");
        String name=request.getParameter("name");
        UsersDao dao=new UsersDaoImpl();
        try {
            StuGradeInfo stuGradeInfo=dao.findTeaGradeInfoBySnoAndName(no,name);
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("stuGradeInfo",stuGradeInfo);
            RequestDispatcher rd= request.getRequestDispatcher("/stuGradeChange.jsp");
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

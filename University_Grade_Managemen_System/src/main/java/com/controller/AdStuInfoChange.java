package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.StuInfo;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdStuInfoChange", value = "/AdStuInfoChange")
public class AdStuInfoChange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        String no=request.getParameter("no");
        UsersDao dao=new UsersDaoImpl();
        try {
            StuInfo stuInfo=dao.findStuInfoByNo(no);
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("stuInfo",stuInfo);
            RequestDispatcher rd= request.getRequestDispatcher("/stuInfoChange.jsp");
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

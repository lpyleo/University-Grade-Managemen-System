package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.StuInfo;
import com.model.TeaInfo;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FuzzyQueryTeaInfo", value = "/FuzzyQueryTeaInfo")
public class FuzzyQueryTeaInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String info=request.getParameter("info");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        ArrayList<TeaInfo> teaInfos=new ArrayList<TeaInfo>();
        UsersDao dao=new UsersDaoImpl();
        try {
            teaInfos=dao.findByFuzzyTeaInfo(info);
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("teaInfos",teaInfos);
            RequestDispatcher rd= request.getRequestDispatcher("/teaInfoManagement.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

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
import java.util.ArrayList;

@WebServlet(name = "FuzzyQueryStuGradeInfo", value = "/FuzzyQueryStuGradeInfo")
public class FuzzyQueryStuGradeInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String info=request.getParameter("info");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        ArrayList<StuGradeInfo> stuGradeInfos=new ArrayList<StuGradeInfo>();
        UsersDao dao=new UsersDaoImpl();
        try {
            stuGradeInfos=dao.findByFuzzyStuGradeInfo(info);
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("stuGradeInfos",stuGradeInfos);
            RequestDispatcher rd= request.getRequestDispatcher("/stuScoreManagement.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

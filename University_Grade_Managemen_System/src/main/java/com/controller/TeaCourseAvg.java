package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.AvgScore;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TeaCourseAvg", value = "/TeaCourseAvg")
public class TeaCourseAvg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        ArrayList<AvgScore> avgScores=new ArrayList<AvgScore>();
        UsersDao dao=new UsersDaoImpl();
        try {
            avgScores=dao.allTeaAvgScore(teachers.getLpy_Tno15());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("avgScores",avgScores);
        RequestDispatcher rd= request.getRequestDispatcher("/teaCourseAvg.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

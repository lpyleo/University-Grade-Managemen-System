package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.StuCourseRank;
import com.model.StuGradeInfo;
import com.model.TeaCourse;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TeaStuRank", value = "/TeaStuRank")
public class TeaStuRank extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        ArrayList<StuCourseRank> stuCourseRanks=new ArrayList<StuCourseRank>();
        ArrayList<TeaCourse> teaCourses= new ArrayList<TeaCourse>();
        UsersDao dao=new UsersDaoImpl();
        try {
            teaCourses=dao.findByFuzzyOneTeaCourse(teachers.getLpy_Tno15());
            TeaCourse t=teaCourses.get(0);
            stuCourseRanks=dao.findStuCourseRank(t.getLpy_Coursename15(),teachers.getLpy_Tno15());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("teaCourses",teaCourses);
        request.getSession().setAttribute("stuCourseRanks",stuCourseRanks);
        RequestDispatcher rd= request.getRequestDispatcher("/teaStuRank.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

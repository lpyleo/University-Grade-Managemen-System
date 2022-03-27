package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.StuCourseRank;
import com.model.TeaCourse;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FindTeaStuCourseRank", value = "/FindTeaStuCourseRank")
public class FindTeaStuCourseRank extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        ArrayList<StuCourseRank> stuCourseRanks=new ArrayList<StuCourseRank>();
        UsersDao dao=new UsersDaoImpl();
        try {
            stuCourseRanks= dao.findStuCourseRank(name,teachers.getLpy_Tno15());
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("stuCourseRanks",stuCourseRanks);
            RequestDispatcher rd= request.getRequestDispatcher("/teaStuRank.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

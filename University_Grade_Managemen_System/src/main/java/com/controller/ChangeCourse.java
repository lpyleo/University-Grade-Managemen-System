package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.Courses;
import com.model.StuInfo;
import com.model.Students;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangeCourse", value = "/ChangeCourse")
public class ChangeCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        String no=request.getParameter("no");
        String name=request.getParameter("name");
        String courseno=request.getParameter("courseno");
        String coursename=request.getParameter("coursename");
        String credit=request.getParameter("credit");
        String hour=request.getParameter("hour");
        String term=request.getParameter("term");
        String method=request.getParameter("method");
        Courses courses=new Courses();
        courses.setLpy_Tno15(no);
        courses.setLpy_Tname15(name);
        courses.setLpy_Courseno15(courseno);
        courses.setLpy_Coursename15(coursename);
        courses.setLpy_Ccredit15(Double.parseDouble(credit));
        courses.setLpy_Chours15(Double.parseDouble(hour));
        courses.setLpy_Cterm15(term);
        courses.setLpy_Assessmentmethod15(method);
        UsersDao dao=new UsersDaoImpl();
        try {
            if(dao.changeCourseInfo(courses)){
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/TeaCourseManagement");
                rd.forward(request,response);
            }else {
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/TeaCourseManagement");
                rd.forward(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

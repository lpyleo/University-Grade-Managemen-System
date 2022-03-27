package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.StuCourse;
import com.model.StuGradeInfo;
import com.model.Students;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StuTermCourse", value = "/StuTermCourse")
public class StuTermCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String term=request.getParameter("term");
        Students students=(Students) request.getSession().getAttribute("students");
        ArrayList<StuCourse> stuCourses=new ArrayList<StuCourse>();
        UsersDao dao=new UsersDaoImpl();
        try {
            if(term.equals("全部学期")){
                stuCourses=dao.findAllStuCourse(students.getLpy_Sno15());
            } else if (term.equals("大一")){
                stuCourses= dao.findAllStuYearCourse(students.getLpy_Sno15(),"一");
            } else if (term.equals("大二")){
                stuCourses= dao.findAllStuYearCourse(students.getLpy_Sno15(),"二");
            } else if (term.equals("大三")){
                stuCourses= dao.findAllStuYearCourse(students.getLpy_Sno15(),"三");
            } else if (term.equals("大四")){
                stuCourses= dao.findAllStuYearCourse(students.getLpy_Sno15(),"四");
            } else {
                stuCourses=dao.findAllStuCourse(students.getLpy_Sno15(),term);
            }
            request.getSession().setAttribute("students",students);
            request.getSession().setAttribute("stuCourses",stuCourses);
            RequestDispatcher rd= request.getRequestDispatcher("/stuCourse.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

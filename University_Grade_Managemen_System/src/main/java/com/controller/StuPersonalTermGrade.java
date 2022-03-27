package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.StuCourse;
import com.model.StuGradeInfo;
import com.model.Students;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StuPersonalTermGrade", value = "/StuPersonalTermGrade")
public class StuPersonalTermGrade extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String term=request.getParameter("term");
        Students students=(Students) request.getSession().getAttribute("students");
        ArrayList<StuGradeInfo> stuGradeInfos=new ArrayList<StuGradeInfo>();
        UsersDao dao=new UsersDaoImpl();
        try {
            if(term.equals("全部学期")){
                stuGradeInfos=dao.findAllStuGrade(students.getLpy_Sno15());
            } else if (term.equals("大一")){
                stuGradeInfos= dao.findAllStuYearGrade(students.getLpy_Sno15(),"一");
            } else if (term.equals("大二")){
                stuGradeInfos= dao.findAllStuYearGrade(students.getLpy_Sno15(),"二");
            } else if (term.equals("大三")){
                stuGradeInfos= dao.findAllStuYearGrade(students.getLpy_Sno15(),"三");
            } else if (term.equals("大四")){
                stuGradeInfos= dao.findAllStuYearGrade(students.getLpy_Sno15(),"四");
            } else {
                stuGradeInfos=dao.findAllStuGrade(students.getLpy_Sno15(),term);
            }
            request.getSession().setAttribute("students",students);
            request.getSession().setAttribute("stuGradeInfos",stuGradeInfos);
            RequestDispatcher rd= request.getRequestDispatcher("/stuGrade.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

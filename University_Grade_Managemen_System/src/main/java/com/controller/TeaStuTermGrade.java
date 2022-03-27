package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.StuGradeInfo;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TeaStuTermGrade", value = "/TeaStuTermGrade")
public class TeaStuTermGrade extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String term=request.getParameter("term");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        ArrayList<StuGradeInfo> stuGradeInfos=new ArrayList<StuGradeInfo>();
        UsersDao dao=new UsersDaoImpl();
        try {
            if(term.equals("全部学期")){
                stuGradeInfos=dao.findByFuzzyStuGradeInfo(teachers.getLpy_Tname15());
            } else if (term.equals("大一")){
                stuGradeInfos= dao.findByFuzzyYearTeaGradeInfo("一",teachers.getLpy_Tname15());
            } else if (term.equals("大二")){
                stuGradeInfos= dao.findByFuzzyYearTeaGradeInfo("二",teachers.getLpy_Tname15());
            } else if (term.equals("大三")){
                stuGradeInfos= dao.findByFuzzyYearTeaGradeInfo("三",teachers.getLpy_Tname15());
            } else if (term.equals("大四")){
                stuGradeInfos= dao.findByFuzzyYearTeaGradeInfo("四",teachers.getLpy_Tname15());
            } else {
                stuGradeInfos=dao.termTeaStuGradeInfo(term,teachers.getLpy_Tname15());
            }
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("stuGradeInfos",stuGradeInfos);
            RequestDispatcher rd= request.getRequestDispatcher("/teaStuGrade.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

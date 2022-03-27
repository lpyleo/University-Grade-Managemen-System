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

@WebServlet(name = "StuTermGrade", value = "/StuTermGrade")
public class StuTermGrade extends HttpServlet {
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
                stuGradeInfos=dao.allStuGradeInfo();
            } else if (term.equals("大一")){
                stuGradeInfos= dao.findByFuzzyYearGradeInfo("一");
            } else if (term.equals("大二")){
                stuGradeInfos= dao.findByFuzzyYearGradeInfo("二");
            } else if (term.equals("大三")){
                stuGradeInfos= dao.findByFuzzyYearGradeInfo("三");
            } else if (term.equals("大四")){
                stuGradeInfos= dao.findByFuzzyYearGradeInfo("四");
            } else {
                stuGradeInfos=dao.termStuGradeInfo(term);
            }
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("stuGradeInfos",stuGradeInfos);
            RequestDispatcher rd= request.getRequestDispatcher("/stuScoreManagement.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.Students;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddTeaInfo", value = "/AddTeaInfo")
public class AddTeaInfo extends HttpServlet {
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
        String college=request.getParameter("college");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String profess=request.getParameter("profess");
        String level=request.getParameter("level");
        String phone=request.getParameter("phone");
        Teachers teachers1=new Teachers();
        teachers1.setLpy_Tno15(no);
        teachers1.setLpy_Tname15(name);
        teachers1.setLpy_Collegeno15(college);
        teachers1.setLpy_Tsex15(sex);
        teachers1.setLpy_Tage15(Integer.parseInt(age));
        teachers1.setLpy_Tprofess15(profess);
        teachers1.setLpy_Tauthoritylevel15(level);
        teachers1.setLpy_Tphone15(phone);
        UsersDao dao=new UsersDaoImpl();
        try {
            if(dao.addTeacher(teachers1)){
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= request.getRequestDispatcher("/TeaInfoManagement");
                rd.forward(request,response);
            }else {
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= request.getRequestDispatcher("/TeaInfoManagement");
                rd.forward(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

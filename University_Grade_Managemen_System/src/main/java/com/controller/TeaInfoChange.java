package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TeaInfoChange", value = "/TeaInfoChange")
public class TeaInfoChange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String no=request.getParameter("no");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String profess=request.getParameter("profess");
        String phone=request.getParameter("phone");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        teachers.setLpy_Tno15(no);
        teachers.setLpy_Tname15(name);
        teachers.setLpy_Tsex15(sex);
        teachers.setLpy_Tage15(Integer.parseInt(age));
        teachers.setLpy_Tprofess15(profess);
        teachers.setLpy_Tphone15(phone);
        UsersDao dao=new UsersDaoImpl();
        try {
            if(dao.changeTeaInfo(teachers)){
                teachers=dao.findTeaByNo(teachers.getLpy_Tno15());
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/teaPersonal.jsp");
                rd.forward(request,response);
            }else {
                teachers=dao.findTeaByNo(teachers.getLpy_Tno15());
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/teaPersonal.jsp");
                rd.forward(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

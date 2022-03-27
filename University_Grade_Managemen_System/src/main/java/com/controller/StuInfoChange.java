package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.Students;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StuInfoChange", value = "/StuInfoChange")
public class StuInfoChange extends HttpServlet {
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
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        Students students=(Students) request.getSession().getAttribute("students");
        students.setLpy_Sno15(no);
        students.setLpy_Sname15(name);
        students.setLpy_Ssex15(sex);
        students.setLpy_Sage15(Integer.parseInt(age));
        students.setLpy_Sphone15(phone);
        students.setLpy_Shometown15(address);
        UsersDao dao=new UsersDaoImpl();
        try {
            if(dao.changeStuInfo(students)){
                students=dao.findStuByNo(students.getLpy_Sno15());
                request.getSession().setAttribute("students",students);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuPersonal.jsp");
                rd.forward(request,response);
            }else {
                students=dao.findStuByNo(students.getLpy_Sno15());
                request.getSession().setAttribute("students",students);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuPersonal.jsp");
                rd.forward(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

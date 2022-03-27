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

@WebServlet(name = "StuChangePassword", value = "/StuChangePassword")
public class StuChangePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String oldpassword=request.getParameter("oldpassword");
        String newpassword1=request.getParameter("newpassword1");
        String newpassword2=request.getParameter("newpassword2");
        Students students=(Students) request.getSession().getAttribute("students");
        UsersDao dao=new UsersDaoImpl();
        if(oldpassword.equals(students.getLpy_Spassword15())&&newpassword1.equals(newpassword2)){
            students.setLpy_Spassword15(newpassword1);
            try {
                if(dao.changeStuPassword(students)){
                    students=dao.findStuByNo(students.getLpy_Sno15());
                    request.getSession().setAttribute("students",students);
                    RequestDispatcher rd= getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request,response);
                }else {
                    students=dao.findStuByNo(students.getLpy_Sno15());
                    request.getSession().setAttribute("students",students);
                    RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuChangePassword.jsp");
                    rd.forward(request,response);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }else {
            try {
                students=dao.findStuByNo(students.getLpy_Sno15());
            } catch (DaoException e) {
                e.printStackTrace();
            }
            request.getSession().setAttribute("students",students);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuChangePassword.jsp");
            rd.forward(request,response);
        }
    }
}

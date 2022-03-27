package com.controller;

import com.dao.DaoException;
import com.dao.UsersDaoImpl;
import com.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String role = request.getParameter("role");
        String no = request.getParameter("no");
        String password = request.getParameter("password");
        Teachers teachers = new Teachers();
        teachers.setLpy_Tauthoritylevel15(role);
        teachers.setLpy_Tno15(no);
        teachers.setLpy_Tpassword15(password);
        Students students = new Students();
        students.setLpy_Sno15(no);
        students.setLpy_Spassword15(password);
        if(role.equals("管理员")){
            try {
                teachers = new UsersDaoImpl().checkAdLogin(teachers);
            } catch (DaoException e) {
                e.printStackTrace();
            }
            if(teachers!=null){
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/AdMain");
                rd.forward(request,response);
            } else {
                response.sendRedirect("loginFailed.jsp");
            }
        }else if (role.equals("普通教师")){
            try {
                teachers = new UsersDaoImpl().checkTeaLogin(teachers);
            } catch (DaoException e) {
                e.printStackTrace();
            }
            if(teachers!=null){
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/TeaMain");
                rd.forward(request,response);
            } else {
                response.sendRedirect("loginFailed.jsp");
            }
        }else if (role.equals("学生")){
            try {
                students = new UsersDaoImpl().checkStuLogin(students);
            } catch (DaoException e) {
                e.printStackTrace();
            }
            if(students!=null){
                request.getSession().setAttribute("students",students);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/StuMain");
                rd.forward(request,response);
            } else {
                response.sendRedirect("loginFailed.jsp");
            }
        }
    }
}

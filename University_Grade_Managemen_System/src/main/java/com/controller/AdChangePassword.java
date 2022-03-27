package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdChangePassword", value = "/AdChangePassword")
public class AdChangePassword extends HttpServlet {
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
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        UsersDao dao=new UsersDaoImpl();
        if(oldpassword.equals(teachers.getLpy_Tpassword15())&&newpassword1.equals(newpassword2)){
            teachers.setLpy_Tpassword15(newpassword1);
            try {
                if(dao.changeTeaPassword(teachers)){
                    teachers=dao.findTeaByNo(teachers.getLpy_Tno15());
                    request.getSession().setAttribute("teachers",teachers);
                    RequestDispatcher rd= getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request,response);
                }else {
                    teachers=dao.findTeaByNo(teachers.getLpy_Tno15());
                    request.getSession().setAttribute("teachers",teachers);
                    RequestDispatcher rd= getServletContext().getRequestDispatcher("/adChangePassword.jsp");
                    rd.forward(request,response);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }else {
            try {
                teachers=dao.findTeaByNo(teachers.getLpy_Tno15());
            } catch (DaoException e) {
                e.printStackTrace();
            }
            request.getSession().setAttribute("teachers",teachers);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/adChangePassword.jsp");
            rd.forward(request,response);
        }
    }
}

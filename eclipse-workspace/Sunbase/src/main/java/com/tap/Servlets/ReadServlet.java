package com.tap.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.Connection.connection;
import com.tap.Dao.StudentDaoImp;
import com.tap.Entity.StudentEntity;

public class ReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static Connection con = null;

    @Override
    public void init() throws ServletException {
        try {
            con = connection.requestConnection();
            System.out.println(con + " success........");
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("Unable to establish database connection", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            StudentDaoImp studentDao = new StudentDaoImp();
            List<StudentEntity> students = studentDao.getAllStudents();
            request.setAttribute("students", students);

            String message = (String) request.getSession().getAttribute("message");
            if (message != null) {
                request.setAttribute("message", message);
                request.getSession().removeAttribute("message");
            }

            request.getRequestDispatcher("/displayStudents.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

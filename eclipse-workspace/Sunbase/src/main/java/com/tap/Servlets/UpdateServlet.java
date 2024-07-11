package com.tap.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.Connection.connection;
import com.tap.Dao.StudentDaoImp;
import com.tap.Entity.StudentEntity;

public class UpdateServlet extends HttpServlet {
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
        	PrintWriter writer = response.getWriter();
            String idParam = request.getParameter("id");
            if (idParam == null) {
                writer.println("<h3>Invalid student ID</h3>");
                return;
            }   System.out.println(idParam);
            int studentId = Integer.parseInt(idParam);

            StudentDaoImp studentDao = new StudentDaoImp();
            StudentEntity student = studentDao.getStudentById(studentId);
            System.out.println(student);
            if (student != null) {
                request.setAttribute("student", student);
                request.getRequestDispatcher("/UpdateStudentDetails.jsp").forward(request, response);
            } else {
                writer.println("<h3>No student found with ID " + studentId + "</h3>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

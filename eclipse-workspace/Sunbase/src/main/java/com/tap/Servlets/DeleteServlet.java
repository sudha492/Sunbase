package com.tap.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.Connection.connection;
import com.tap.Dao.StudentDaoImp;

public class DeleteServlet extends HttpServlet {
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
            String idParam = request.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                response.getWriter().println("<h3>Invalid student ID</h3>");
                return;
            }
            int studentId = Integer.parseInt(idParam);

            StudentDaoImp studentDao = new StudentDaoImp();
            boolean isDeleted = studentDao.deleteStudentById(studentId);

            String message;
            if (isDeleted) {
                message = "Student with ID " + studentId + " deleted successfully.";
            } else {
                message = "Failed to delete student with ID " + studentId + ".";
            }
            request.getSession().setAttribute("message", message);
            response.sendRedirect(request.getContextPath() + "/displayStudents");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

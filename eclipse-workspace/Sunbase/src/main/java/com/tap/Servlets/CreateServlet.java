package com.tap.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.Connection.connection;
import com.tap.Dao.StudentDaoImp;
import com.tap.Entity.StudentEntity;

public class CreateServlet extends HttpServlet {
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
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            StudentEntity e = new StudentEntity(id, name, email, age);
            System.out.println(e);
            StudentDaoImp s = new StudentDaoImp();
            StudentEntity s1=s.getStudentByEmail(email);
            StudentEntity s2=s.getStudentById(id);
            String message;
            if(Objects.nonNull(s2)) {
            	message = "Student id : " +id + " already exist!";
            }
            else if(Objects.nonNull(s1)) {
            	message = "Student email id : " + email +" already exist!";
            }
            else{
            	boolean isAdded = s.adddata(e);
            if (isAdded) {
                message = "Student " + name + " added successfully!";
            } else {
                message = "Failed to add student " + name + ".";
            }
            }
            request.setAttribute("message", message);
            request.getRequestDispatcher("/displayStudents").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

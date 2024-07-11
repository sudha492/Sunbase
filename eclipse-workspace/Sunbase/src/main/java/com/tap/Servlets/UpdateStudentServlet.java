package com.tap.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.Connection.connection;

public class UpdateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection con = null;

        try {
            System.out.println("im in update..................");
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));

            con = connection.requestConnection();
            String query = "UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, age);
            pstmt.setInt(4, id);
       
            int rowsAffected = pstmt.executeUpdate();
            String message;
            if (rowsAffected > 0) {
                message = "Student details updated successfully";
            } else {
                message = "Failed to update student details";
            }
            request.getSession().setAttribute("message", message);
            response.sendRedirect(request.getContextPath() + "/displayStudents");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

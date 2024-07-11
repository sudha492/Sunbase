package com.tap.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.Connection.connection;
import com.tap.Entity.StudentEntity;

public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String criterion = request.getParameter("criterion");
        String value = request.getParameter("value");

        List<StudentEntity> students = new ArrayList<>();
        Connection con = null;

        try {
            con = connection.requestConnection();
            String query = "SELECT * FROM students WHERE " + criterion + " = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            if (criterion.equals("id") || criterion.equals("age")) {
                pstmt.setInt(1, Integer.parseInt(value));
            } else {
                pstmt.setString(1, value);
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                StudentEntity e=new StudentEntity(id, name, email, age);
                System.out.println(e);
                students.add(e);
            }

        } catch (ClassNotFoundException | SQLException e) {
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

        request.setAttribute("students1", students);
        request.getRequestDispatcher("/searchResults.jsp").forward(request, response);
    }
}

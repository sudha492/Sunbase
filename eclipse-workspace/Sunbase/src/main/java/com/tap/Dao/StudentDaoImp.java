package com.tap.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.tap.Connection.connection;
import com.tap.Entity.StudentEntity;

public class StudentDaoImp implements StudentDao{
	 static Connection con=null;
	 @Override
		public boolean adddata(StudentEntity e) throws ServletException {
		 try {
	            con = connection.requestConnection();
	           PreparedStatement pstmt=null;
	            int id=e.getId();
	            String name=e.getName();
	            String email=e.getEmail();
	            int age=e.getAge();
	            String query="insert into students(`id`,`name`,`email`,`age`) values (?,?,?,?)";
	            pstmt=con.prepareStatement(query);
	            pstmt.setInt(1,id);
	            pstmt.setString(2,name);
	            pstmt.setString(3,email);
	            pstmt.setInt(4,age);
	            int r=pstmt.executeUpdate();
	            if(r>0) {
	            	System.out.println("Query executed.....");
	            	return true;
	            }
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
		return false;
	    }
	 public List<StudentEntity> getAllStudents() throws ServletException {
	        List<StudentEntity> students = new ArrayList<>();
	        try {
	            con = connection.requestConnection();
	            String query = "SELECT * FROM students";
	            PreparedStatement pstmt = con.prepareStatement(query);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String email = rs.getString("email");
	                int age = rs.getInt("age");
	                StudentEntity student = new StudentEntity(id, name, email, age);
	                students.add(student);
	            }
	        } catch (SQLException | ClassNotFoundException e1) {
	            e1.printStackTrace();
	        } finally {
	            if (con != null) {
	                try {
	                    con.close();
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        }
	        return students;
	    }

	public StudentEntity getStudentById(int id) throws ServletException {
	    StudentEntity student = null;
	    try {
	        con = connection.requestConnection();
	        String query = "SELECT * FROM students WHERE id = ?";
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, id);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            String name = rs.getString("name");
	            String email = rs.getString("email");
	            int age = rs.getInt("age");
	            student = new StudentEntity(id, name, email, age);
	        }
	    } catch (SQLException | ClassNotFoundException e1) {
	        e1.printStackTrace();
	    } finally {
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }
	    return student;
	}
	  public boolean deleteStudentById(int id) throws ServletException {
	        boolean isDeleted = false;
	        try {
	            con = connection.requestConnection();
	            String query = "DELETE FROM students WHERE id = ?";
	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, id);
	            int rowsAffected = pstmt.executeUpdate();
	            isDeleted = rowsAffected > 0;
	        } catch (SQLException | ClassNotFoundException e1) {
	            e1.printStackTrace();
	        } finally {
	            if (con != null) {
	                try {
	                    con.close();
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        }
	        return isDeleted;
	    }
	public StudentEntity getStudentByEmail(String email) {
		  StudentEntity student = null;
		    try {
		        con = connection.requestConnection();
		        String query = "SELECT * FROM students WHERE email = ?";
		        PreparedStatement pstmt = con.prepareStatement(query);
		        pstmt.setString(1, email);
		        ResultSet rs = pstmt.executeQuery();

		        if (rs.next()) {
		            int id = rs.getInt("id");
		            String name = rs.getString("name");
		            int age = rs.getInt("age");
		            student = new StudentEntity(id, name, email, age);
		        }
		    } catch (SQLException | ClassNotFoundException e1) {
		        e1.printStackTrace();
		    } finally {
		        if (con != null) {
		            try {
		                con.close();
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		    return student;
	}


}

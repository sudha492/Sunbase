package com.tap.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {

	static Connection con = null;
	static String url = "jdbc:mysql://localhost:3306/student_db";
	static String un = "root";
	static String pwd = "root";

	static public Connection requestConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, un, pwd);
		return con;
	}
	public static void main(String[] args) {
		try {
			Connection con=connection.requestConnection();
			System.out.println("done....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
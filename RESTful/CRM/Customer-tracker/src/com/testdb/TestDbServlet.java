package com.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "springstudent";
		String pass = "springstudent";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&useTimezone=true&serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
				PrintWriter out = response.getWriter();
				out.print("Connecting to "+ jdbcUrl);
				
				Class.forName(driver);
				
				Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);
				out.print("Done...");
				
				connection.close();
				
			}catch(Exception e) {
				e.printStackTrace(); throw new ServletException(e);
			}
		
	}

}

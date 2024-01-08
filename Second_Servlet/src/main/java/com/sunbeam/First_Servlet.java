package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class First_Servlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			resp.setContentType("text/html");
			 PrintWriter out = resp.getWriter();
			 out.println("<html>");
			 out.println("<head>");
			 out.println("<title>Hello K-Dac</title>");
			 out.println("</head>");
			 out.println("<body>");
			 out.println("<h1>Hello, Servlet!</h1>");
			 Date d = new Date();
			 out.println("Current time: " + d.toString()); 
			 out.println("</body>");
			 out.println("</html>");
		}
}

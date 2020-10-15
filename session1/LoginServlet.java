package com.sistec.session1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	resp.setContentType("text/html");
	PrintWriter writer=resp.getWriter();
	String uname=req.getParameter("uname");
	String pwd=req.getParameter("pwd");
	RequestDispatcher dispatcher;
	if(uname.equals("Admin") && pwd.equals("Admin123")) {
		HttpSession session=req.getSession();
		session.setAttribute("uname", uname);
		
		dispatcher=req.getRequestDispatcher("HomeServlet");
		dispatcher.forward(req, resp);
	}else {
		writer.print("Please enter valid login details");
		dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
	}
}
}

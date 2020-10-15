package com.sistec.session1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class ServletLogout extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	
	HttpSession session=req.getSession(false);
	PrintWriter writer=resp.getWriter();
	if(session!=null) {
		session.invalidate();
		writer.print("Logout Success");
		req.getRequestDispatcher("login.jsp").include(req, resp);
		
	}else {
		writer.print("Please Login First Then You Can Logout");
		req.getRequestDispatcher("login.jsp").include(req, resp);
	}
}
}

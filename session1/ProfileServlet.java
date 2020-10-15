package com.sistec.session1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet
public class ProfileServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	PrintWriter pw=resp.getWriter();
	resp.setContentType("text/html");
	HttpSession session=req.getSession(false);
	if(session!=null) {
	String uname=(String) session.getAttribute("uname");
	pw.print("uname:"+uname);
	req.getRequestDispatcher("link.html").include(req, resp);
	
	}else {
		pw.print("Pleas login first");
		req.getRequestDispatcher("login.jsp").include(req, resp);
	}
}
}

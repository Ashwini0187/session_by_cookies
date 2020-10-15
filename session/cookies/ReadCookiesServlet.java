package com.sistec.session.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ReadCookiesServlet")
public class ReadCookiesServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Cookie c[]=req.getCookies();
	PrintWriter writer=resp.getWriter();
	
	if(c!=null) {
		for(Cookie cookie:c) {
			if(cookie.getName().equals("name")) {
				writer.print("Name:"+cookie.getValue());
			}else if(cookie.getName().equals("rno")) {
				writer.print("R.No:"+cookie.getValue());
			}
		}
	}else {
		writer.print("No Cookies");
	}
	writer.close();
}
}

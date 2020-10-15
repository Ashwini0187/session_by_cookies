package com.sistec.session.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateCookiesServlet")
public class CreateCookiesServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		Cookie c1=new Cookie("name", "Aman gupta");
		Cookie c2=new Cookie("rno", "96");
		
		c1.setMaxAge(300);
		
		
		resp.addCookie(c1);
		resp.addCookie(c2);
	} catch (Exception e) {
		System.out.println(e);
	}
}
}

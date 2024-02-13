package com.sessionTracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveCookie")
public class SaveCookiesInBrowser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("id", "1");
		cookie1.setMaxAge(200);
		Cookie cookie2 = new Cookie("email", "ask@gmail.com");
		cookie2.setMaxAge(600);
		Cookie cookie3 = new Cookie("password", "12345");
		cookie3.setMaxAge(6000);/* setMaxAge() is used to set the cookies expire time*/
		resp.addCookie(cookie1);  /* addCookie() is used to save cookies in the browser*/
		resp.addCookie(cookie2);
		resp.addCookie(cookie3);
		PrintWriter pout = resp.getWriter();
		pout.println("<h1>Cookies saved</h1>");
	}

}

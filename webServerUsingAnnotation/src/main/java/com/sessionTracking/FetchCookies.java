package com.sessionTracking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetchCookie")
public class FetchCookies extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookie = req.getCookies();
		for (int i = 0; i < cookie.length; i++) {
			Cookie c = cookie[i];
			System.out.println(c.getName() + " " + c.getValue());
		}
	}

}

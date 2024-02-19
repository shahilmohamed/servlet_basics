package com.sessionTracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginvalidate")
public class LoginValidation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		if(email.equals("shahil.m.mohamed@gmail.com") && password.equals("1234")) {
			Cookie c = new Cookie("email", email);
			Cookie c2 = new Cookie("password", password);
			resp.addCookie(c);
			c.setMaxAge(10);
			resp.addCookie(c2);
			c2.setMaxAge(10);

			RequestDispatcher rd = req.getRequestDispatcher("welcome.html");
			rd.forward(req, resp);
		} else {
			PrintWriter pout = resp.getWriter();
			pout.println("<h1>Enter valid credentials</h1>");
			RequestDispatcher rd = req.getRequestDispatcher("login2.html");
			rd.include(req, resp);
		}
	}

}

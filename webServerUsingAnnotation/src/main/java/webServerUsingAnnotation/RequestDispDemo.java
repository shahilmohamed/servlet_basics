package webServerUsingAnnotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/forwardrequest")
public class RequestDispDemo extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		if(user.equals("admin")&&password.equals("root"))
		{
			RequestDispatcher re = req.getRequestDispatcher("form.html");
			re.forward(req, res);
		}
		else
		{
			PrintWriter pout = res.getWriter();
			pout.println("Invalid user or password");
			RequestDispatcher re = req.getRequestDispatcher("requestDisp1.html");
			re.include(req, res);
			res.setContentType("text/html");
			
		}
		
	}
 
}

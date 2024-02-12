package webServerUsingAnnotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/code")
public class PrintDataOnBrowser extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		PrintWriter pout = res.getWriter();
		pout.println("<h1 style= color:red>Welcome "+name+"</h1>");
		
	}

}

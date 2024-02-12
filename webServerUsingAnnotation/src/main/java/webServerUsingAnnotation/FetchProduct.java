package webServerUsingAnnotation;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/productDetails")
public class FetchProduct extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String product = req.getParameter("name");
		String category = req.getParameter("category");
		String price = req.getParameter("price");
		System.out.println(id);
		System.out.println(product);
		System.out.println(category);
		System.out.println(price);
	}

}

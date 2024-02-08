package webServerUsingAnnotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/product")
public class Product extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String brand = req.getParameter("brand");
		String category = req.getParameter("category");
		String price = req.getParameter("price");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into product (id,brand,category,price) values(?,?,?,?)");
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, brand);
			ps.setString(3, category);
			ps.setDouble(4, Double.parseDouble(price));
			ps.execute();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pout = res.getWriter();
		pout.println("<h1 style= color:yellow>Product details entered</h1>");
	}

}

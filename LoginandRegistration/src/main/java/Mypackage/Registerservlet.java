package Mypackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Registerservlet
 */
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registerservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/form";
			String username = "root";
			String password = "Pass@123";

			Connection conn = DriverManager.getConnection(url, username, password);
			String query = "INSERT INTO registration (Name,Email,Password,Gender,City) VALUES (?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setString(2, email);
			pstm.setString(3, password);
			pstm.setString(4, gender);
			pstm.setString(5, city);

			int count = pstm.executeUpdate();
			HttpSession session = request.getSession();
			if (count > 0) {
				response.setContentType("text/html");
				request.setAttribute("message", "Registration successfull!");
				request.setAttribute("messageType", "success");
				request.getRequestDispatcher("registration.jsp").forward(request, response);

			} else {
				request.setAttribute("message", "Registration failed. Please try again.");
				request.setAttribute("messageType", "error");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("message", e.getMessage());
			request.setAttribute("messageType", "error1");
			RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
			rd.forward(request, response);
		}
	}

}

package Mypackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class logserv
 */
public class logserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/form";
			String username = "root";
			String password = "Pass@123";
			
			Connection conn = DriverManager.getConnection(url, username, password);
			String query = "SELECT * FROM registration WHERE Email= ? AND Password=?";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, pass);
			
			ResultSet rs=pstm.executeQuery();
			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("sname",rs.getString("name"));
				
//				request.getRequestDispatcher("profile.jsp").forward(request, response);
				response.sendRedirect("profile.jsp");
				
			}else {
				request.setAttribute("message", "Incorrect Email Id or Password!");
				request.setAttribute("messageType", "lerror");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			request.setAttribute("messageType", "lerror1");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
	

}

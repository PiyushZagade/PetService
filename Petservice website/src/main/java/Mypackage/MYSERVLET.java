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
 * Servlet implementation class MYSERVLET
 */
public class MYSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MYSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>This servlet only handles POST requests.</h1>");
//        out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneno = request.getParameter("phoneno");
		String message = request.getParameter("message");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/petservice";
			String username="root";
			String password="Pass@123";
			
			Connection conn = DriverManager.getConnection(url ,username, password);
			String query="INSERT INTO userinfo (Name,Email,Phoneno,Message) VALUES (?,?,?,?)";
			PreparedStatement pstm =conn.prepareStatement(query);
			pstm.setString(1 ,name);
			pstm.setString(2, email);
			pstm.setString(3, phoneno);
			pstm.setString(4, message);
			
			int count = pstm.executeUpdate();
			HttpSession session =request.getSession();
			if (count > 0) {
                session.setAttribute("key", name);
                response.sendRedirect("index.jsp"); // Redirect to index.jsp
            } else {
                response.sendRedirect("index.html"); // Redirect to index.html
            }

			
			conn.close();
			
		}catch(Exception e) { 
			e.printStackTrace();
			response.setContentType("text/html");
			out.println(" <h2 style='color:red'>"+ e.getMessage() +" </h2>");
			RequestDispatcher rd= request.getRequestDispatcher("/index.html");
			rd.include(request, response);
//			response.sendRedirect("index.html");
		}
	}

}

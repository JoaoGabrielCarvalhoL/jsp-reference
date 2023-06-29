package br.com.carv.app.servlet;

import java.io.IOException;

import br.com.carv.app.payload.LoginRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if (email != null && !email.isBlank() && password != null && !password.isBlank()) {
			LoginRequest loginRequest = new LoginRequest(email, password);
			request.getSession().setAttribute("userCredentials", loginRequest);
			RequestDispatcher redirect = request.getRequestDispatcher("pages/home.jsp");
			redirect.forward(request, response);
		} else {
			RequestDispatcher redirect = request.getRequestDispatcher("index.jsp");
			request.setAttribute("message", "Invalid Email or Password!");
			redirect.forward(request, response);
		}
		
	}

}

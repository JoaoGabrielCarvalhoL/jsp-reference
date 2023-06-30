package br.com.carv.app.servlet;

import java.io.IOException;
import java.sql.SQLException;

import br.com.carv.app.dao.LoginDAO;
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
	private final LoginDAO loginDAO = new LoginDAO();

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
		String uri = request.getParameter("uri");

		if (email != null && !email.isBlank() && password != null && !password.isBlank()) {

			LoginRequest loginRequest = new LoginRequest(email, password);

			try {
				if (loginDAO.authenticate(loginRequest)) {
					request.getSession().setAttribute("user", loginRequest);

					if (uri == null || uri.equals("null")) {
						uri = "pages/home.jsp";
					}
					RequestDispatcher redirect = request.getRequestDispatcher(uri);
					redirect.forward(request, response);

				} else {
					RequestDispatcher redirect = request.getRequestDispatcher("index.jsp");
					request.setAttribute("message", "Invalid Email or Password!");
					redirect.forward(request, response);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

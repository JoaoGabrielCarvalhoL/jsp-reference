package br.com.carv.app.filter;

import java.io.IOException;
import java.io.Serial;

import br.com.carv.app.payload.LoginRequest;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter extends HttpFilter implements Filter {
	
	@Serial
	private static final long serialVersionUID = 0L;
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AuthenticationFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		LoginRequest loggedUser = (LoginRequest) session.getAttribute("user");
		
		String uriAuthentication = httpServletRequest.getServletPath();
		
		if (loggedUser == null && !uriAuthentication.contains("ServletLogin")) {
			RequestDispatcher redirect = request.getRequestDispatcher("/index.jsp?uri=" +  uriAuthentication);
			request.setAttribute("message", "It is necessary to login the system");
			redirect.forward(httpServletRequest, response);
			
		} else {
			chain.doFilter(request, response);			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

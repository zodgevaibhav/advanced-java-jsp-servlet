package com.uiapi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uiapi.busn.users.LoginAuthentication;

/**
 * Servlet implementation class UserNameAvailabilityCheck
 */
public class UserNameAvailabilityCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNameAvailabilityCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("******************* Verify if Username is available - "+request.getParameter("id"));
		response.setContentType("text/html");
		if(LoginAuthentication.isUserNameAvailable(request.getParameter("id")))
			response.getWriter().println("true1");
		else
			response.getWriter().println("false1");
	}
}

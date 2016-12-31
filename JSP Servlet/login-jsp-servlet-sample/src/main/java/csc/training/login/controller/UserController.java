package csc.training.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csc.training.login.dao.UserDao;
import csc.training.login.model.User;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	public UserController() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("logout")) {
			request.getSession().setAttribute("userid", null);
			request.getSession().invalidate();
			response.sendRedirect("index.jsp");
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("registration")) {
			User user = new User();
			user.setFirstName(request.getParameter("fname"));
			user.setLastName(request.getParameter("lname"));
			user.setEmail(request.getParameter("email"));
			user.setUserName(request.getParameter("uname"));
			user.setPassword(request.getParameter("pass"));
			
			int result = dao.addUser(user);
			if (result > 0)
				response.sendRedirect("welcome.jsp");
			else 
				response.sendRedirect("index.jsp");
			
		} else if (action.equalsIgnoreCase("login")) {
			String username = request.getParameter("uname");
			String password = request.getParameter("pass");
			
			if (username != null && username.trim().length() > 0
				&& password != null && password.trim().length() > 0){
				boolean result = dao.checkLoginUser(username.trim(), password.trim());
				
				if (result){
					request.getSession().setAttribute("userid", username);;
					response.sendRedirect("success.jsp");
					
				} else {
					response.sendRedirect("index.jsp");
				}
				
			} else {
				response.sendRedirect("index.jsp");
			}
		}
		
	}
}

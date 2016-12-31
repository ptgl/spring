package csc.training.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csc.training.login.dao.UserDao;
import csc.training.login.model.User;

public class ProfileController extends HttpServlet {
	private UserDao dao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProfileController() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			String name = (String) session.getAttribute("userid");

			if (name != null){
				User user = dao.getUserById(name);
				request.setAttribute("userInfo", user);
				request.getRequestDispatcher("profile.jsp").forward(request, response);
				
			} else{
				response.sendRedirect("index.jsp");
			}
			
		} else {
			response.sendRedirect("index.jsp");
		}
	}
}

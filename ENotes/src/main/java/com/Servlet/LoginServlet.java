package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.UserBean;
import com.DAO.UserDAO;

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");
		
		UserBean ub = new UserBean();
		ub.setEmail(email);
		ub.setPassword(password);
		
		UserBean user = new UserDAO().loginUser(ub);
		
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userD", user);
			response.sendRedirect("Home.jsp");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("login-failed", "Invalid Username or Password");
			response.sendRedirect("Login.jsp");
		}
	}

}

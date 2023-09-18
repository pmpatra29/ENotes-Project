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
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");

		UserBean ub = new UserBean();
		ub.setName(name);
		ub.setEmail(email);
		ub.setPassword(password);

		boolean f = new UserDAO().addUser(ub);
		
		HttpSession session ;
		
		if (f) {
			session = request.getSession();
			session.setAttribute("reg-success", "Registration Successfully...");
			response.sendRedirect("Register.jsp");
		}
		else {
			session = request.getSession();
			session.setAttribute("failed-msg", "Something went wrong on server");
			response.sendRedirect("Register.jsp");
		}
	}

}

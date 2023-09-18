package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.PostDAO;
import com.Db.DBConnection;

@SuppressWarnings("serial")
@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			
		try {
			
			Integer noteid = Integer.parseInt(request.getParameter("noteid"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			PostDAO dao = new PostDAO(DBConnection.getCon());
			boolean f = dao.PostUpdate(noteid, title, content);
			
			if(f) {
				
				System.out.println("data updated");
				HttpSession session = request.getSession();
				session.setAttribute("updateMsg", "Notes Update Successfully");
				response.sendRedirect("ShowNotes.jsp");
				
			}else {
				System.out.println("Data not updated");
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

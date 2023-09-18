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
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String noteIdStr = request.getParameter("note_id");
		if (noteIdStr != null) {
			noteIdStr = noteIdStr.trim();
			try {
				Integer noteid = Integer.parseInt(noteIdStr);
				PostDAO dao = new PostDAO(DBConnection.getCon());

				boolean f = dao.deleteNotes(noteid);

				HttpSession session = null;

				if (f) {

					session = request.getSession();
					session.setAttribute("updateMsg", "Notes Deleted Successfully!!");
					response.sendRedirect("ShowNotes.jsp");
					
				} else {

					session = request.getSession();
					session.setAttribute("wrongMsg", "Something went wrong on server..");
					response.sendRedirect("ShowNotes.jsp");
				}

			} catch (NumberFormatException e) {

			}

		}

	}

}

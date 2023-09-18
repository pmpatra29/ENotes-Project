<%@page import="com.Bean.PostBean"%>
<%@page import="com.Db.DBConnection"%>
<%@page import="com.DAO.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
UserBean user1 = (UserBean) session.getAttribute("userD");

if (user1 == null) {
	response.sendRedirect("Login.jsp");
	session.setAttribute("Login-error", "Please Login...");
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Notes</title>
<%@include file="All_Component/AllCss.jsp"%>
</head>
<body>

	<div class="container-fluid">
		<%@include file="All_Component/NavBar.jsp"%>

		<h1 class="text-center">Edit Your Notes</h1>


		<div class="container">
			<div class="row">
				<div class="col-md-12">


					<form action="NoteEditServlet" method="post">

						<%
						String noteIdStr1 = request.getParameter("note_id");
						if (noteIdStr1 != null) {
							noteIdStr1 = noteIdStr1.trim(); // Remove leading and trailing whitespace
							try {
								Integer noteid2 = Integer.parseInt(noteIdStr1);
						%>
						<input type="hidden" value="<%=noteid2%>" name="noteid" />
						<%
						} catch (NumberFormatException e) {
						// Handle the case where the input string is not a valid integer
						}

						}
						%>

						<div class="form-group">

							<label for="exampleInputEmail1">Enter Title</label>

							<%
							String noteIdStr = request.getParameter("note_id");
							if (noteIdStr != null) {
								noteIdStr = noteIdStr.trim();
								try {
									Integer noteid = Integer.parseInt(noteIdStr); // Declare noteid within this scope
									// Use the parsed integer value (noteid) as needed within this block
									PostDAO post = new PostDAO(DBConnection.getCon());
									PostBean p = post.getDataById(noteid);
							%>

							<input type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title"
								value="<%=p.getTitle()%>">

							<%
							} catch (NumberFormatException e) {
							// Handle the case where the input string is not a valid integer
							}
							}
							%>


						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>

							<%
							String noteIdStr3 = request.getParameter("note_id");
							if (noteIdStr3 != null) {
								noteIdStr3 = noteIdStr3.trim();
								try {
									Integer noteid3 = Integer.parseInt(noteIdStr3); // Declare noteid within this scope
									// Use the parsed integer value (noteid) as needed within this block
									PostDAO post = new PostDAO(DBConnection.getCon());
									PostBean p = post.getDataById(noteid3);
							%>

							<textarea rows="9" cols="" class="form-control" name="content"
								required><%= p.getContent() %></textarea>

							<%
							} catch (NumberFormatException e) {
							// Handle the case where the input string is not a valid integer
							}
							}
							%>

							

						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Update Notes</button>

						</div>

					</form>

				</div>
			</div>

		</div>
	</div>

	<%@include file="All_Component/Footer.jsp"%>

</body>
</html>
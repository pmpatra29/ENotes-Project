<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
UserBean user2 = (UserBean) session.getAttribute("userD");

if (user2 == null) {
	response.sendRedirect("Login.jsp");
	session.setAttribute("Login-error", "Please Login...");
}
%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<%@include file="All_Component/AllCss.jsp"%>

</head>
<body>
	
	<div class="container-fluid p-0">
		<%@include file="All_Component/NavBar.jsp"%>
		<div class="card py-5">
			<div class="card-body text-center" >
				<img alt="" src="Image/note1.png" class="img-fluid mx-auto" style="width: 300px">
				<h1>START TAKING YOUR NOTES</h1>
				<a href="AddNotes.jsp" class="btn btn-outline-primary">Start Here</a>
			</div>
		</div>
	</div>

<%@include file="All_Component/Footer.jsp" %>
</body>
</html>
<%@page import="com.Db.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.background-img {
	background: url("Image/enotes2.jpg");
	width: 100%;
	height: 80vh;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@include file="All_Component/AllCss.jsp"%>
</head>
<body>

	<%@include file="All_Component/NavBar.jsp"%>
	
	
	
	<div class="container-fluid background-img">
		<div class="text-center ">
			<h1 class="text-white">
				<i class="fa fa-book" aria-hidden="true"></i>E Notes-Save Your Notes
			</h1>
			<a href="Login.jsp" class="btn btn-light"><i class="fa fa-user"
				aria-hidden="true"></i>Login</a> <a href="Register.jsp"
				class="btn btn-light"><i class="fa fa-user-plus"
				aria-hidden="true"></i>Register</a>
		</div>

	</div>

	<div class="container-fluid bg-dark mt-1">
	<p class="text-center text-white">Note: Any Errors occur then contact <a href="https://www.linkedin.com/in/panchanan-mahapatra/">CoderBoySubha</a>. Designed and developed by Panchanan Mahapatra</p>
	
	<p class="text-center text-white">All rights Reserved @CoderBoySubha 2023-24</p>
</div>

</body>
</html>
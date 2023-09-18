<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="All_Component/AllCss.jsp"%>
</head>
<body>

	<%@include file="All_Component/NavBar.jsp"%>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user fa-3x" aria-hidden="true"></i>
						<h4>Login Page</h4>
					</div>

					<%
					String invalidMsg = (String) session.getAttribute("login-failed");

					if (invalidMsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=invalidMsg%></div>
					<%
					session.removeAttribute("login-failed");
					}
					%>

					<%
					String withOutLogin = (String) session.getAttribute("Login-error");
					if (withOutLogin != null) {
					%>

					<div class="alert alert-danger" role="alert"><%=withOutLogin%></div>

					<%
					session.removeAttribute("Login-error");
					}
					%>

					<%
					String logoutMsg = (String) session.getAttribute("LogoutMsg");
					if (logoutMsg != null) {
					%>

					<div class="alert alert-success" role="alert"><%=logoutMsg%></div>

					<%
					session.removeAttribute("LogoutMsg");
					}
					%>


					<div class="card-body">
						<form action="LoginServlet" method="post">

							<div class="form-group">
								<label>Enter Email ID</label> <input type="email"
									class="form-control" id="exampleInputEmail1" name="uemail"
									aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password</label> <input
									type="password" class="form-control" name="upassword"
									id="exampleInputPassword1">
							</div>
							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Login</button>
						</form>
					</div>

				</div>

			</div>
		</div>



	</div>

	<div class="container-fluid bg-dark mt-1">
	<p class="text-center text-white">Note: Any Errors occur then contact <a href="https://www.linkedin.com/in/panchanan-mahapatra/">CoderBoySubha</a>. Designed and developed by Panchanan Mahapatra</p>
	
	<p class="text-center text-white">All rights Reserved @CoderBoySubha 2023-24</p>
</div>


</body>
</html>
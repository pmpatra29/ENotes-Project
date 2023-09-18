<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<%@include file="All_Component/AllCss.jsp"%>


</head>
<body>
	<%@include file="All_Component/NavBar.jsp"%>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
						<h4>Registration</h4>
					</div>


					<%
					String successMsg = (String) session.getAttribute("reg-success");
					if (successMsg != null) {
					%>
					<div class="alert alert-success" role="alert"><%=successMsg%><a href="Login.jsp">Login</a></div>
					<%
					session.removeAttribute("reg-success");
					
					}
					%>


					<%
					String failedMsg = (String) session.getAttribute("failed-msg");
					if (failedMsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=failedMsg%></div>
					<%
					session.removeAttribute("failed-msg");
					
					}
					%>



					<div class="card-body">
						<form action="UserServlet" method="post">
							<div class="form-group">
								<label>Enter Full Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="uname">
							</div>
							<div class="form-group">
								<label>Enter Email ID</label> <input type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="uemail">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									name="upassword">
							</div>
							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Register</button>
						</form>
					</div>

				</div>

			</div>
		</div>



	</div>

	<div class="container-fluid bg-dark mt-1">
	<p class="text-center text-white">Note: Any Errors occur then contact CoderBoySubha. Designed and developed by Panchanan Mahapatra</p>
	
	<p class="text-center text-white">All rights Reserved @CoderBoySubha 2023-24</p>
</div>
</body>
</html>
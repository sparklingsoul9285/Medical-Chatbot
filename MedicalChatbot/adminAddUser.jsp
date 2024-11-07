<%@page import="java.sql.ResultSet"%>
<%@page import="dbConnector.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<title>Chat Bot</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css"
	href="assets/font/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="assets/font/font.css" />
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css" media="screen" />
<link rel="stylesheet" type="text/css" href="assets/css/style.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="assets/css/responsive.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="assets/css/jquery.bxslider.css" media="screen" />
<script type="text/javascript" src="assets/js/jquery-min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.bxslider.js"></script>
<script type="text/javascript" src="assets/js/selectnav.min.js"></script>
</head>
<body>
	<jsp:include page="adminheader.jsp"></jsp:include>
	<%
		String Result = request.getParameter("Result");
	%>
	<!-- <div class="body_wrapper">
		<div class="center">

			<div class="container">
				<div class="row" style="padding: 1%;">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div
							class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
							<br>
		
					 -->		
			<div class="body_wrapper">
		<div class="center">

		
			<div class="container">
				<div class="row" style="padding: 1%;">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-2 col-md-8 col-lg-offset-2 col-lg-8">
							<div class="pageform">
					
							
							<h3 style="color: #0084b4; text-align: center; margin-bottom: 7%">New
									User Registration</h3>
								<form action="./StudentRegisteration" method="post" name="ureg">
									<br> <br> <br> <br>
									<br> <label>First Name</label><br>
										<input type="hidden" name="u_type" value="Admin">
									 <input type="text"
										name="fname" required="required"
										onblur="return AllowAlphabet()"><br> <label>Last
										Name</label><br> <input type="text" name="lname"
										required="required" onblur="return AllowAlphabet()"><br>
									<label>Mobile Number</label><br> <input type="text"
										name="mnumber" required="required" onblur="return Validate()"><br>
									<label>Email Address</label><br> <input type="email"
										name="email" required="required" onblur="return validEmail()"><br>
									<label>Birthday</label><br> <input type="date" name="dob"
										required="required" onblur="return ageCount()"><br>
									<label>Gender</label><br> <input type="radio"
										name="gender" value="Male" checked="checked"
										required="required">Male <input type="radio"
										name="gender" value="Female">Female<br> <label>Password</label><br>
									<input type="password" name="password" required="required"
										onblur="return validuaernameandpass()"><br>
									<button type="submit">Register</button>

								</form>
							
				
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	

</body>
</html>
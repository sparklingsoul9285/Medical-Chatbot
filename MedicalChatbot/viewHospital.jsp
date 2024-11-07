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
String Result=request.getParameter("Result");

%>
	<div class="body_wrapper">
		<div class="center">

			<div class="container">
				<div class="row" style="padding: 1%;">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div
							class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
							<br>
							<div align="center" ><h1 style="color: red">Hospital Details</h1></div>
							
							
									<table class="table "
											style="width: 100%; margin: 0; border: 1px solid #fff; color: #82e0aa; font-size: 15px">
											<thead>
												<tr>
													<th>Sr.No</th>
													<th>Hospital Name</th>
													<th>Latitude</th>
													<th>Longitude</th>
													<th>Mobile No</th>
												</tr>
												</thead>
											<%
												DbConnection dbConnection=new DbConnection();
												ResultSet rs=dbConnection.selectOperation("SELECT * FROM `hospital_details`");
												int ii=0;
												try
												{
												while(rs.next())
											  	{
													ii++;
												%>
												<tr style="color: black;">
													<td><%=ii %></td>
													<td><%=rs.getString("h_name") %></td>
													<td><%=rs.getString("h_lat") %></td>
													<td><%=rs.getString("h_long") %></td>
													<td><%=rs.getString("h_mobile") %></td>
												</tr>
												<%
		
											  	}
												}
												catch(Exception e)
												{
													System.out.print("Exc "+e);
												}
												%>
											</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
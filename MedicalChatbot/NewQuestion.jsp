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
if(Result.equals("Duplicate"))
{
	out.print("<script>alert('Mobile or Email Address Already Registered')</script>");
}

%>
	<div class="body_wrapper">
		<div class="center">
			
            <div class="container">
            <div class="row" style="padding:1%;">
            <div class="col-sm-12 col-md-12 col-lg-12">
            <div class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
            <br>
								<br>
                        <div class="table-responsive" >          
                        <table class="table " style="width: 100%;margin: 0;border: 1px solid #fff;color: #82e0aa;font-size: 15px">
                        <thead>
                        <tr>
						<th>Question No</th>
						<th>Question</th>
						<th>Date</th>
						<th>Ask By</th>
						<th>Answer</th>
						<th>Warn Student</th>
						</tr>
						<%
						DbConnection dbConnection=new DbConnection();
						ResultSet rs=dbConnection.selectOperation("SELECT * FROM `newquestion` WHERE status ='Waiting'");
						rs.last();
						int count=rs.getRow();
						rs.beforeFirst();
						if(count>0)
						{
						while(rs.next())
						{
							int srno=rs.getInt("srno");
							String question=rs.getString("question");
							String date=rs.getString("date");
							int uid=rs.getInt("askby");
							ResultSet rs1=dbConnection.selectOperation("SELECT * FROM studentrecord where sid='"+uid+"'");
							String name="";
							if(rs1.next())
							{
							name=rs1.getString("firstname")+" "+rs1.getString("lastname");	
							}
						%>
						<tr>
						<td><%=srno %></td>
						<td><%=question %></td>
						<td><%=date %></td>
						<td><%=name %></td>
						<td><button style="height: auto;width:auto;margin:0;padding: 2%;background-color:#82e0aa;border: none;color: #fff ">Answer the Question</button></td>
						<td><button style="height: auto;width:auto;margin:0;padding: 2%;background-color:#82e0aa;border: none;color: #fff ">warn <%=name %></button></td>
				         </tr>
				         <%
						}
						}
						else
						{
						%>
						<tr>
						<td>No Questions</td>
						</tr>
						<%	
						}
				         %>
					     </thead>
						</table>
						</div>
            </div>
            </div>
            </div>
            </div>
		</div>
	</div>


</body>
</html>
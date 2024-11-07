<%@page import="javax.websocket.Session"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dbConnector.DbConnection"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>

</head>
<body>
	<jsp:include page="userHeader.jsp"></jsp:include>
	<%
		response.setHeader("Pragma","no-cache"); // HTTP 1.0
	response.setHeader("Cache-Control","no-store"); // HTTP 1.1
	response.setDateHeader("Expires", 0);
	Integer id=(Integer)session.getAttribute("id");
	if(id==null)
	{
		response.sendRedirect("UserSignIn.jsp?Result=");	
	}
	else
	{
String Result=request.getParameter("Result");
if(Result.equals("Duplicate"))
{
	out.print("<script>alert('Mobile or Email Address Already Registered')</script>");
}

%>
	<div class="body_wrapper">
		<div class="center">
			<div class="container" style="height: 250px">
				<div class="row" style="padding: 1%;">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div
							class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-2 col-md-8 col-lg-offset-2 col-lg-8">

							<script>
var x = document.getElementById("demo");
var lt = document.getElementById("lt");
var lng = document.getElementById("lng");

function getLocation() 
{
  if (navigator.geolocation) 
  {
    navigator.geolocation.getCurrentPosition(showPosition);
  } else 
  { 
    x.innerHTML = "Geolocation is not supported by this browser.";
  }
}

function showPosition(position) 
{
 /*  x.innerHTML = "Latitude: " + position.coords.latitude + 
  "<br>Longitude: " + position.coords.longitude;
  */ 
  var lt = position.coords.latitude;
  var lng = position.coords.longitude;
  
  document.getElementById("lt").value=lt;
  document.getElementById("lng").value=lng;;
  
  var latlng = new google.maps.LatLng(lt, lng);
  var geocoder = geocoder = new google.maps.Geocoder();
  geocoder.geocode({ 'latLng': latlng }, function (results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
          if (results[1]) {
              alert("Location: " + results[1].formatted_address);
          }
      }
  });
  
  
// location.href='ChatbotInteraction.jsp?a='+lt+'&b='+lng+'&Result=';
  
}
</script>

							<div class="table-responsive">

								<table class="table "
									style="width: 100%; height: auto; margin: 0; border: 1px solid #fff; color: #82e0aa; font-size: 15px">
										<tr>
											<th><button onclick="getLocation()"><h2 style="color: #82e0aa; text-align: center; margin-bottom: 7%"><blink>Click Here for Get Current Location</blink><img alt="" src="imgs/loc.gif" style="width: 40%"></button></h2> </th>
										</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row" style="padding: 1%;">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div align="center"
							class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-2 col-md-8 col-lg-offset-2 col-lg-8">
							<div class="pageform" style="border: 0px solid;">
								<!-- <img alt="" src="imgs/chat.JPG"
									onclick="location.href='ChatbotInteraction.jsp?Result='"> -->
								
								<form action="SetCurrentLocation" method="POST">
									<input type="text" id="lt" style="width: 120px;" name="lt" required> <input
										type="text" id="lng" style="width: 120px;" name="lng" required> <input
										type="submit" value="Start Chat">
								</form>


							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
	}
%>

</body>
</html>
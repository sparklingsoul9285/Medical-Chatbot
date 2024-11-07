<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>



<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="css/nivo-lightbox.css" rel="stylesheet" />
<link href="css/nivo-lightbox-theme/default/default.css"
	rel="stylesheet" type="text/css" />
<link href="css/owl.carousel.css" rel="stylesheet" media="screen" />
<link href="css/owl.theme.css" rel="stylesheet" media="screen" />
<link href="css/animate.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet">
<link href="color/default.css" rel="stylesheet">

<title>People</title>
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
<style>
.speech {
	border: 1px solid #DDD;
	width: 360px;
	padding: 0;
	margin: 0
}

.speech textarea {
	border: 0;
	width: 350px;
	display: inline-block;
	height: 70px;
}

/* .speech img new Voicemsg {
	float: right;
	width: 40px
} */
</style>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom"
	onkeydown="CheckKey()">
	<!-- Preloader -->

	<div class="body_wrapper">
		<div class="center">
			<div class="header_area">
				<div class="logo floatleft">
					<a href="index.jsp"><img src="imgs/logo.png" alt="" /></a>
				</div>
			</div>
			<div class="main_menu_area" style="margin-top: 10px"></div>

			<%
if(request.getParameter("reg")!=null)
{
	out.print("<script>alert('Your Request Send Successfully..!')</script>");
}
%>

			<div class="container">
				<div class="row" style="padding: 1%;">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div
							class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-2 col-md-8 col-lg-offset-2 col-lg-8">
							<!-- 	<form action="SignInServlet" method="post" name="ureg"> -->
							<br /> <br /> <br /> <br /> <br />
							<form id="labnol" name="ureg" method="post">
								<!-- <div class="pageform"> -->
								<div class="speech">
									<textarea rows="5" cols="40" placeholder="Speak"
										name="requirment" id="transcript" onblur="return getData()"></textarea>
								</div>
							</form>
							<br /> <br /> <br /> <br /> <br />
							<br /> <br /> <br /> <br /> <br />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		function getData() {
			var text = document.ureg.requirment.value;
		//	alert(text);
			window.location = "FromUserData?requirment="+text;

		}
	</script>
	<!-- HTML5 Speech Recognition API -->
	<script>
		function CheckKey() {
			if (event.keyCode === 13) {
				event.preventDefault();
				startDictation();
			}
		}
		function startDictation() {

			if (window.hasOwnProperty('webkitSpeechRecognition')
					|| window.hasOwnProperty('SpeechRecognition')) {

				var recognition = new webkitSpeechRecognition()
						|| new SpeechRecognition();

				recognition.continuous = false;
				recognition.interimResults = false;

				recognition.lang = "en-US";
				recognition.start();

				recognition.onresult = function(e) {
					console.log(e.results);
					document.getElementById('transcript').value = e.results[0][0].transcript;
					recognition.stop();
					//   document.getElementById('labnol').submit();
				};

				recognition.onerror = function(e) {
					recognition.stop();
				}

			}
		}
	</script>


	<script type="text/javascript" src="assets/js/jquery-min.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/jquery.bxslider.js"></script>
	<script type="text/javascript" src="assets/js/selectnav.min.js"></script>
	<script type="text/javascript">
selectnav('nav', {
    label: 'Menu',
    nested: true,
    indent: '>'
});

</script>

</body>
</html>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Home</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="<c:url value="/resources/bootstrap/assets/css/ie10-viewport-bug-workaround.css"/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="<c:url value="/resources/bootstrap/navbar-static-top.css"></c:url>"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="/resources/bootstrap/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="<c:url value="/resources/bootstrap/assets/js/ie-emulation-modes-warning.js"/>"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>Welcome to WOW Restaurant</h1>
			<p>"Ordinary?" No! That's the last word we want to hear from you!

At WOW BARBECUE, Nothing is ordinary!  

WOW BARBECUE features a wide range of flavors paired with beautiful presentation and the  color, aroma, and taste of authentic Chinese food.

Bring your friends to WOW BARBECUE and enjoy a culinary experience unlike any other. 

Don't forget to check out our Twitter and Facebook to see special offers for big sports games,  and special events!</p>
			<p></p>
			<p>
				<a class="btn btn-lg btn-primary" href="https://www.facebook.com/wowbarbecue/"
					role="button">More Information &raquo;</a>
			</p>
		</div>

	</div>
	<!-- /container -->

	

</body>

</html>

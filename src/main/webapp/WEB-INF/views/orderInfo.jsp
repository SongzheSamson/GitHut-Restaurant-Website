<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Edit user</title>

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
<div class = "container">
<div class ="jumbotron">

	<h2>Order Information</h2>
	<form:form modelAttribute="order" action="sendOrder" method="post">
		<table class = "table table-striped">
			<tr>
				<td><form:label for="customerName" path="customerName"
						cssErrorClass="error">Customer Name:</form:label></td>
				<td><form:input path="customerName" /> <form:errors
						path="customerName" /></td>
			</tr>
			<tr>
				<td><form:label for="address" path="address"
						cssErrorClass="error">Address:</form:label></td>
				<td><form:input path="address" /> <form:errors path="address" />
				</td>
			</tr>
			<tr>
				<td><form:label for="phoneNumber" path="address"
						cssErrorClass="error">Photo Number:</form:label></td>
				<td><form:input path="phoneNumber" /> <form:errors
						path="phoneNumber" /></td>
			</tr>
			<tr>
				<td><form:label for="type" path="type" cssErrorClass="error">Deliver or Pick up</form:label></td>
				<td><form:select path="type">

						<form:option value="PICK_UP">Pick Up</form:option>
						<form:option value="DELEVER">Deliver</form:option>

					</form:select>
					<form:errors path="type" /></td>

			</tr>

			<tr>
				<td><input type="submit" value="Send" /></td>
				<td></td>
			</tr>

		</table>
	<sec:authorize access="isAuthenticated()">
	<a href="autoFill" >Use Your Register Address</a>
	</sec:authorize>
	</form:form>
</div>
</div>
</body>
</html>
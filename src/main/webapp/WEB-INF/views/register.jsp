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

<title>Register</title>

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
	<div class = "jumbotron">
		<h1>Register</h1>
		<div>
			<form:form modelAttribute = "registerUser" action = "register" method = "post">
				<table  class ="table table-striped">
					<tr>
						<td><form:label for="username" path="username" cssErrorClass="error">User Name:</form:label></td>
						<td><form:input path="username" />
						<form:errors path="username" /></td>
					</tr>
					<tr>
						<td><form:label for="password" path="password" cssErrorClass="error">Password:</form:label></td>
						<td><form:password path="password" />
						<form:errors path="password" /></td>
					</tr>
					<tr>
						<td><form:label for="firstName" path="firstName" cssErrorClass="error">First Name:</form:label></td>
						<td><form:input path="firstName" />
						<form:errors path="firstName" /></td>
					</tr>
					<tr>
						<td><form:label for="lastName" path="lastName" cssErrorClass="error">Last Name:</form:label></td>
						<td><form:input path="lastName" />
						<form:errors path="lastName" /></td>
					</tr>
					<tr>
						<td><form:label for="address" path="address" cssErrorClass="error">Address:</form:label></td>
						<td><form:input path="address" />
						<form:errors path="address" /></td>
					</tr>
					<tr>
						<td><form:label for="email" path="email" cssErrorClass="error">Email:</form:label></td>
						<td><form:input path="email" />
						<form:errors path="email" /></td>
					</tr>
					<tr>
						<td><form:label for="phone" path="email" cssErrorClass="phone">Phone:</form:label></td>
						<td><form:input path="phone" />
						<form:errors path="phone" /></td>
					</tr>
					<tr>
						<td><input type="submit" value = "Register"/></td>
						<td></td>
					</tr>
					
				</table>			
			</form:form>
			
		</div>
		</div>
	</div>
</body>
</html>
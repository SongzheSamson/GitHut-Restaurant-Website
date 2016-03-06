<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>


<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Static Top Navbar Example for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"  rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="<c:url value="/resources/bootstrap/assets/css/ie10-viewport-bug-workaround.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/bootstrap/navbar-static-top.css"></c:url>" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="/resources/bootstrap/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="<c:url value="/resources/bootstrap/assets/js/ie-emulation-modes-warning.js"/>"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class ="container">
<div class ="jumbotron">
<h1>Customer</h1>
<c:if test="${! empty usersCustomer }">
	<table class = "table table-striped">
	<tr>
	<td>User Name</td>
	<td></td>
	</tr>
	<c:forEach items="${usersCustomer }"  var="users">
		<tr>
		<td>${users.username }</td>
		<td><a href="admin/${users.username}/edit">edit</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

<h1>Manager</h1>
<c:if test="${! empty usersManager }">
	<table class = "table table-striped">
	<tr>
	<td>User Name</td>
	<td></td>
	</tr>
	<c:forEach items="${usersManager }"  var="users">
		<tr>
		<td>${users.username }</td>
		<td><a href="admin/${users.username}/edit">edit</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<br>
<form action="admin/register" method = "GET">
    <input type="submit" value="Register New Manager">
</form>
</div>
</div>
</body>
</html>
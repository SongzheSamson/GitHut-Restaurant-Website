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

<title>Menus</title>

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
		<h1>Create Menu</h1>
		<div class="jumbotron">
			<form:form modelAttribute="menu" action="menus" method="post">
				<fieldset>
					<legend>Menu Fields</legend>
					<p>
						<form:label for="menuName" path="menuName" cssErrorClass="error">Menu Name:</form:label>
						<br />
						<form:input path="menuName" />
						<form:errors path="menuName" />
					</p>
					<p>
						<form:label for="description" path="description"
							cssErrorClass="error">Description:</form:label>
						<br />
						<form:textarea path="description" />
						<form:errors path="description" />
					</p>
						
						<input type="submit" />
					</p>
				</fieldset>
			</form:form>

			
			<h2>Menu</h2>
			<c:if test="${!empty menuList}">
				<ul style="list-style-type: none">
					<c:forEach items="${menuList}" var="menu">
						<table class = "jumbotron">
						<tr>
							<td>MenuName:</td>
							<td>${menu.menuName}</td>
						</tr>
						<tr>
							<td>Description:</td>
							<td>${menu.description}</td>
						</tr>
						<tr>
							<td>Edit Date:</td>
							<td>${menu.editTime}</td>
						</tr>
						<tr>
							<td><a href = "menus/${menu.menuId }/edit">Edit Menu </a></td>
							<td><a href = "menus/${menu.menuId }/removeMenu">Remove Menu</a></td>
						</tr>	

						</table>
					</c:forEach>
				</ul>
				<br>
			</c:if>
		</div>
	</div>
</body>
</html>
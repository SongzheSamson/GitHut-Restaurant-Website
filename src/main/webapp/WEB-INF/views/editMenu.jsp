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

<title>Edit Menu</title>

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
	<h1>Add Foods</h1>
	
	
	<div class="jumbotron">	
		<form:form modelAttribute="menuFood" action="addFood" method="post">
		  	<fieldset>		
				<legend>Manage Menu Field</legend>
				<p>
					Menu Name: ${menu.menuName }
				</p>
				<p>
					<form:label	for="foodName" path="food.foodName">Food Name:</form:label><br/>
					<form:select items="${foodList}"  itemLabel="foodName"  itemValue="foodId" path="food.foodId" />
				</p>
				<p>
					<form:label for="price" path="price" cssErrorClass="error">Price:</form:label><br/>
					<form:input path="price" /> <form:errors path="price" />
				</p>
				<p>	
					<input type="submit" />
				</p>
			</fieldset>
		</form:form>
	
		<h2>Foods</h2>

		<c:if test="${!empty menuFoodList}">
			<table class ="table table-striped">
			<tr>
				<td>Picture</td>
				<td>Name</td>
				<td>Type</td>
				<td>Price</td>
				<td>Remove</td>
			</tr>
				<c:forEach items="${menuFoodList}" var="menuFood">
					<tr>

						<td><img src="${menuFood.food.foodId}/photo" height="100"
							width="100" /></td>

						<td>${menuFood.food.foodName}</td>
						<td>${menuFood.food.foodType}</td>
						<td>$${menuFood.price}</td>
						<td><a href = "${menuFood.id }/removeFood">remove</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	</div>
</body>
</html>
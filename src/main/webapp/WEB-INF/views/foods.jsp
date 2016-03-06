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
	<div class="container">
	<div class = "jumbotron">
		<div class = "row">
		<div class="col-md-5">
			<h2>Input Foods</h2>
			<form:form modelAttribute="food" action="foods" method="post"
				enctype="multipart/form-data">

					<table class="table table-striped">
					
						<tr>
						<td>
						<form:label for="foodName" path="foodName" cssErrorClass="error">Food Name:</form:label>
						</td>
						<td>
						<form:input path="foodName" />
						<form:errors path="foodName" />
						</td>
						</tr>
						<tr>
						<td>
						<form:label for="foodType" path="foodType" cssErrorClass="error">Food type:</form:label>
						</td>
						<td>
						<form:select path="foodType">
							<form:option value="Main">Main</form:option>
							<form:option value="Drink">Drink</form:option>
							<form:option value="Appetizer">Appetizer</form:option>
							<form:option value="Dessert">Dessert</form:option>

						</form:select>
						
						<form:errors path="foodType" />
						</td>
					</tr>
						<tr>
					<td>
						<form:label for="descrption" path="descrption"
							cssErrorClass="error">Food Description:</form:label>
						</td>
						<td>
						<form:textarea path="descrption" />
						<form:errors path="descrption" />
						</td>
					</tr>
					<tr>
					<td>
						<form:label for="material" path="material" cssErrorClass="error">Food Material:</form:label>
						</td>
						<td>
						<form:input path="material" />
						<form:errors path="material" />
						</td>
					</tr>
					<tr>
					<td>
					<form:label for="photo" path="photo" cssErrorClass="error">Food Photo:</form:label>
					</td>
					<td>
					<form:input path="photo" type="file" />
					<form:errors path="material" />
					</td>
					</tr>
					<tr>
					<td></td>
					<td>
						<input type="submit" />
						</td>
					</tr>
				</table>
			</form:form>
			</div>
			<div class="col-md-7">
			<h2>Foods</h2>
			<c:if test="${!empty foodList}">
				<table class ="table table-bordered table-striped">
				<tr>
					<td></td>
					<td>Name</td>
					<td>Type</td>
					<td>Description</td>
					<td>Material</td>
					<td></td>
				</tr>
					<c:forEach items="${foodList}" var="food">
						<tr>

							<td><img src="foods/${food.foodId}/photo" height="100"
								width="100" /></td>

							<td>${food.foodName}</td>
							<td>${food.foodType}</td>
							<td>${food.descrption}</td>
							<td>${food.material}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
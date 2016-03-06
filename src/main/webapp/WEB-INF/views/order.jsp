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

<title>Order</title>

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
<jsp:include page="header.jsp"></jsp:include>
<body>
	<div class="container">
		<div class="jumbotron">
		<h2>${succeed }</h2>
			<h1>Create An Order</h1>
			<div class="span-12 last">
				<fieldset>
					<legend>Add Food</legend>
					<c:if test="${!empty menuFoodList }">
						<table class="table table-striped">
							<tr>
								<td></td>
								<td>Name</td>
								<td>Price</td>
								<td>Number</td>
								<td></td>
							</tr>
							<c:forEach items="${menuFoodList}" var="menuFood">
								<form:form modelAttribute="orderFood"
								
									action="/myweb/orders/${menuFood.menu.menuId}/addFood" method="post">
									<tr>
										<td><img src="/myweb/orders/${menuFood.food.foodId}/photo" height="100"
								width="100" /></td>
										<td>${menuFood.food.foodName }</td>
										<td>$${menuFood.price }</td>
										<td><form:input path="number" /> <form:hidden
												path="food.foodId" value="${menuFood.food.foodId }" /> <form:hidden
												path="food.foodName" value="${menuFood.food.foodName }" />
											<form:hidden path="price" value="${menuFood.price }" /></td>
										<td><input type="submit" value="Add" /></td>
									</tr>

								</form:form>
							</c:forEach>
						</table>
					</c:if>
				</fieldset>
				
				<c:if test="${!empty order.orderFoodList }">
					<h1>Order:</h1>
					<table class="table table-striped">
						<tr>
							
							<td>Name</td>
							<td>Price</td>
							<td>Number</td>
							<td></td>
						</tr>
						<c:set var="index" value="0" />
						<c:forEach items="${order.orderFoodList }" var="orderFood">
							<tr>
								
								<td>${orderFood.food.foodName }</td>
								<td>$${orderFood.price }</td>
								<td>
									<form action="/myweb/orders/updateFood">
										<input type="text" name="number" value="${orderFood.number }" />
										<input type="hidden" name="index" value="${index }" /> <input
											type="submit" value="Update" />
									</form>
								</td>
								<td>
									<form action="/myweb/orders/${index }/deleteFood">
										<input type = "submit" value = "Delete">
									</form>
								</td>
								<c:set var="index" value="${index+1 }" />
							</tr>

						</c:forEach>


					</table>
					<p>Total: $${order.totlePrice }</p>
					<br>
					<form action="/myweb/orders/orderInformation">
						<input type="submit" value="Confirm">
					</form>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
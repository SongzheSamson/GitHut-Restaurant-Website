<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
			<div class="jumbotron">
			<h1>Order for Lunch</h1>
			<a href="orders/1">
				<img alt="" src="<c:url value="/resources/img/lunch.jpg"></c:url>">
			</a>
			<br>
			<h1>Order for Dinner</h1>
			<a href="orders/2">
				<img alt="" src="/resources/img/dinner.jpg">
			</a>
			</div>
		</div>
</body>
</html>
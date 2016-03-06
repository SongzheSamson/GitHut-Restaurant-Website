<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Foods</title>
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/screen.css" />"
	type="text/css" media="screen, projection">
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/print.css" />" type="text/css"
	media="print">
<!--[if lt IE 8]>
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection">
<![endif]-->
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="span-12 last">
			<h1>Input User Name and Password</h1>
			<form:form modelAttribute="loginUser" action="j_spring_security_check" method="post">
				<fieldset>
					<legend>User Field</legend>
					<p>
						<form:label for="userName" path="userName" cssErrorClass="error">User Name:</form:label>
						<br />
						<form:input path="userName" /><form:errors path="userName" />
					</p>
					
					<p>
						<form:label for="password" path="password"
							cssErrorClass="error">Password:</form:label>
						<br />
						<form:input path="password" />
						<form:errors path="password" />
					</p>
					
					<p>
						<input type="submit" value = "Login" />
					</p>
				</fieldset>



			</form:form>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		
	<h1>Manager Console</h1>
		<p><sec:authentication property="name"/></p>
		<br>
	
		<div>
		<a href = "foods">manager console</a>
		<br>
		<a href = "menus">Menu manage</a>
		</div>
</body>
</html>
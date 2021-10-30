<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
	<%
		session.invalidate();
	%>
	<h1>Thanks for visiting our website, Will see you soon!</h1>
	<a href="Login.jsp">Login</a>
</body>
</html>
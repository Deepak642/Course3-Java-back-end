<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign_class</title>
</head>
<body>
	<%
		String usernameSession = (String) session.getAttribute("username");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("invalid.jsp");
		}
	%>
	<h2>Assign classes for subjects</h2>
	<form action="AssignClass">
  		<label for="sub">Choose a Subject:</label>
  		<select id="sub" name="sub">
    	<option value="1">English</option>
    	<option value="2">Maths</option>
    	<option value="3">Social</option>
    	<option value="4">Science</option>
  		</select>
  		<label for="cls">Choose a Class:</label>
  		<select id="cls" name="cls">
    	<option value="1">Class-1</option>
    	<option value="2">Class-2</option>
    	</select>
  		<input type="submit" value="Submit">
	</form>

</body>
</html>
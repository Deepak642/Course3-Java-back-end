<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign_Teachers</title>
</head>
<body>
<%
		String usernameSession = (String) session.getAttribute("username");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("invalid.jsp");
		}
	%>
	<h2>Assign Teachers for a subject</h2>
	<form action="AssignTeacher">
  		<label for="sub">Choose a Subject:</label>
  		<select id="sub" name="sub">
    	<option value="1">English</option>
    	<option value="2">Maths</option>
    	<option value="3">Social</option>
    	<option value="4">Science</option>
  		</select>
  		<label for="tch">Choose a Teacher:</label>
  		<select id="tch" name="tch">
    	<option value="1">Prakash</option>
    	<option value="2">Ramesh</option>
    	<option value="3">Suresh</option>
    	<option value="4">Mahesh</option>
    	</select>
  		<input type="submit" value="Submit">
	</form>


</body>
</html>
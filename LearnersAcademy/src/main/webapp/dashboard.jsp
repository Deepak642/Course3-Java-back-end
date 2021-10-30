<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<%
		String usernameSession = (String) session.getAttribute("username");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("invalid.jsp");
		}
	%>
	<h2>Welcome to Learners Academy</h2>
	<a href="logout.jsp">Logout</a><br><br>
	<a href="StudentList"> <button >View Students</button></a>
	<a href="TeachersList"> <button >View Teachers</button></a>
	<a href="subjects"> <button >View Subjects</button></a>
	<a href="ClasssList"> <button >View Classses</button></a><br><br>
	<a href="assignclass.jsp"> <button >Assign Classes</button></a>
	<a href="assignteacher.jsp"> <button >Assign Teachers</button></a><br><br>
	<a href="Class1Report"> <button >View Class-1 Report</button></a>
	<a href="Class2Report"> <button >View Class-2 Report</button></a>

</body>
</html>
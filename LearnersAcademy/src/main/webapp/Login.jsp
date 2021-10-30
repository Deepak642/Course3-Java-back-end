<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LearnersAcademyLogin</title>
</head>
<body>
<h1> Login(Admin) </h1>   
    <form action="AdminLogin" method="POST">  
        <label for="username">User name</label><br>
  		<input type="text" id="username" name="username"><br>
  		<label for="password">Password</label><br>
  		<input type="text" id="password" name="password"><br>
  		<input type="submit" value="Submit">
    </form>   

</body>
</html>
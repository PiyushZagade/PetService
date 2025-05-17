<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
 

	<div class="container">

		<form action="Registerservlet" method="post">
			<label> Username </label> <input type="text"
				placeholder="Enter your name " name="name"> <br> <br>

			<label> Email ID</label> <input type="email"
				placeholder="Enter your email " name="email" required> <br>
			<br> <label> Password</label> <input type="password"
				placeholder="Enter your password " name="pass" required> <br>
			<br> <input type="radio" name="gender" value="Male" checked>Male
			<input type="radio" name="gender" value="Female">Female <br>
			<br> <label>City</label> <select name="city">
				<option>Select city</option>
				<option>Pune</option>
				<option>Nashik</option>
				<option>Chennai</option>
				<option>Chinchwad</option>
			</select> <br> <br> <input type="submit" name="register"
				value="Register">

			<div class="link-container">
				<a href="login.jsp">Login</a> <a href="index.html">Home</a>
			</div>
		</form>
		
		<%
        String message = (String) request.getAttribute("message");
        String messageType = (String) request.getAttribute("messageType");
        if ("success".equals(messageType)) {
    %>
        <div class="message success"><%= message %></div>
    <%
        }
    %>
		
		<%
        if ("error".equals(messageType)) {
    %>
        <div class="message error"><%= message %></div>
    <%
        }
    %>
    
    
    <%
        if ("error1".equals(messageType)) {
    %>
        <div class="message error"><%= message %></div>
    <%
        }
    %>
	</div>
	
</body>
</html>
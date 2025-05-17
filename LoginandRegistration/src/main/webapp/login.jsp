<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<link rel="stylesheet" href="style.css">

<body>

	<div class="container">

		<form action="logserv" method="post">
			<label> Email ID</label> <input type="email"
				placeholder="Enter your email " name="email" required> <br>

			<br> <label> Password</label> <input type="password"
				placeholder="Enter your password " name="pass" required> <br>
			<br> <input type="submit" name="login" value="Login">

			<div class="link-container">
				<a href="registration.jsp">Register</a> <a href="index.html">Home</a>
			</div>
		</form>
		<%
		String message = (String) request.getAttribute("message");
		String messageType = (String) request.getAttribute("messageType");
		if ("success".equals(messageType)) {
		%>
		<div class="message success"><%=message%></div>
		<%
		}
		%>

		<%
		if ("lerror".equals(messageType)) {
		%>
		<div class="message error"><%=message%></div>
		<%
		}
		%>


		<%
		if ("lerror1".equals(messageType)) {
		%>
		<div class="message error"><%=message%></div>
		<%
		}
		%>

	</div>

</body>
</html>
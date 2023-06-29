<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<h1>Sign In!</h1>

	<form action="ServletLogin" method="post">
			
		<label>Email</label>
		<input name="email" type="email"/>
		
		<label>Password</label>
		<input name="password" type="password" /> 
		
		<button type="submit">Send</button>
	</form>
	
	<p>${message}</p>
</body>
</html>

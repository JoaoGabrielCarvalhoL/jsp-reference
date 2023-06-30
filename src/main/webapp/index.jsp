<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	
	<div style="display: flex; justify-content: center; align-items: center; margin-top: 15px;">
		<h1>Sign In</h1>
	</div>
	
	<div style="display: flex; justify-content: center; align-items: center; margin-top: 20px;">
		
		<form class="mb-3" action="ServletLogin" method="post">
			<div>
				<input type="hidden" value="<%=request.getParameter("uri")%>"
					name="uri" /> <label for="exampleInputEmail1" class="form-label">Email
					address</label> <input type="email" class="form-control" name="email">
				<div id="emailHelp" class="form-text">We'll never share your
					email with anyone else.</div>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" class="form-control" name="password">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<p>${message}</p>
		</form>

		
	</div>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
		crossorigin="anonymous">
</body>
</html>

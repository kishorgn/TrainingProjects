<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<%
if(request.getAttribute("loginMsg")!=null){
	%>
	<%= request.getAttribute("loginMsg") %>
	<%
	request.removeAttribute("loginMsg");
}
%>
	<h2>User Credentials</h2>
	<form action="loginController" method="post">
		<label for="username">User Name</label>
		<input type="text" name="username" id="username"><br><br>
		<label for="password">Password</label>
		<input type="password" name="password" id="password"><br><br>
		<input type="submit" value="Login">
		<input type="reset" value="Cancel">
	</form>
	
</body>
</html>
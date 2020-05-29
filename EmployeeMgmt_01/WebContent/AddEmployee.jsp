<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addemp</title>
</head>
<body>
	<h2>Enter Employee details</h2>
	<form action="addEmployeeController" method="post">
		<label for="name">Name</label>
		<input type="text" name="name"><br><br>
		<label for="dob">Date of Birth (dd-mm-yyyy)</label>
		<input type="text" name="dob"><br><br>
		<label for="deptno">Department No</label>
		<input type="text" name="deptno"><br><br>
		<label for="bsal">Basic Salary</label>
		<input type="text" name="bsal"><br><br>
		<input type="submit" value="Add Employee" />
		<input type="reset" value="Cancel">
	</form>
</body>
</html>
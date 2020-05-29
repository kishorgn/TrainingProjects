<%@page import="com.ignite.beans.Employee"%>
<%@page import="com.ignite.service.EmployeeDaoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>editemp</title>
</head>
<body>
<%
	String strId = request.getParameter("id");
	int id = Integer.parseInt(strId);
	EmployeeDaoService employeeDaoService = new EmployeeDaoService();
	Employee employee = employeeDaoService.find(id);
%>
	<h2>Verify and Update Details</h2>
	<form action="editEmployeeController" method="post">
	
		<label for="id">Emp ID</label>
		<input type="text" name="id" value="<%= id %>" readonly="readonly"><br><br>
		<label for="name">Name</label>
		<input type="text" name="name" value="<%= employee.getName() %>"><br><br>
		<label for="dob">Date of Birth (dd-mm-yyyy)</label>
		<input type="text" name="dob" value="<%= employee.getDob() %>"><br><br>
		<label for="deptno">Department No</label>
		<input type="text" name="deptno" value="<%= employee.getDeptno() %>"><br><br>
		<label for="bsal">Basic Salary</label>
		<input type="text" name="bsal" value="<%= employee.getBsal() %>"><br><br>
		<input type="submit" value="Update Employee" />
		<input type="reset" value="Cancel">
	</form>

</body>
</html>
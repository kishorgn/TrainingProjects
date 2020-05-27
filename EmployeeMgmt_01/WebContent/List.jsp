<%@page import="com.ignite.service.EmployeeService"%>
<%@page import="com.ignite.service.EmployeeDaoService"%>
<%@page import="com.ignite.beans.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.ignite.dao.EmployeeJdbcDao"%>
<%@page import="com.ignite.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
	<h2>List of Employees</h2>
	<%
		EmployeeService employeeService = new EmployeeDaoService();
		List<Employee> employees = employeeService.findAll();
		%>
		<table style="width: 80%;">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>DoB</th>
			<th>DeptNo</th>
			<th>BasicSal</th>
			<th>Edit</th>
		</tr>
		<%
		for(Employee employee : employees){
			%>
			<tr>
			<td><%= employee.getId() %></td>
			<td><%= employee.getName() %></td>
			<td><%= employee.getDob() %></td>
			<td><%= employee.getDeptno() %>
			<td><%= employee.getBsal() %></td>
			<td><a href="#">Edit</a> | <a href="#">Delete</a></td>
			</tr>
			<%
		}
	%>
	</table>
</body>
</html>
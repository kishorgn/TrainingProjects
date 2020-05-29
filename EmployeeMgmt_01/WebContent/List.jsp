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

	<%
		if(session.getAttribute("empid")!=null){
			Integer empid = (Integer)session.getAttribute("empid");
			%>
			New employee created with id : <%= empid %>
			<%
			empid = null;
			session.removeAttribute("empid");
		}
	
		if(session.getAttribute("editMsg")!=null){
			%>
			<%= session.getAttribute("editMsg") %><br><br>
			<%
			session.removeAttribute("editMsg");
		}
		
		if(session.getAttribute("delMsg")!=null){
			%>
			<%= session.getAttribute("delMsg") %>
			<%
			session.removeAttribute("delMsg");
		}
	
	%>
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
			<td><a href="EditEmployee.jsp?id=<%= employee.getId()%>">Edit</a> | 
				<a href="deleteEmployeeController?id=<%=employee.getId()%>" onclick="return confirm('Are you sure to delete <%= employee.getName() %> details?')">Delete</a></td>
			</tr>
			<%
		}
	%>
	</table>
	<br>
	<br>
	<a href="AddEmployee.jsp">Add new employee</a><br><br>
	<a href="signoutController">Signout</a>
</body>
</html>
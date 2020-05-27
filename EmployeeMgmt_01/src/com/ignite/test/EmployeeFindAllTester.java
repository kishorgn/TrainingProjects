package com.ignite.test;

import java.sql.SQLException;
import java.util.List;

import com.ignite.beans.Employee;
import com.ignite.dao.EmployeeDAO;
import com.ignite.dao.EmployeeJdbcDao;

public class EmployeeFindAllTester {
	
	public static void main(String[] args) {
		try {
			EmployeeDAO employeeDao = new EmployeeJdbcDao();
			List<Employee> employees = employeeDao.findAll();
			for(Employee employee : employees) {
				System.out.println(employee.toCSV());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

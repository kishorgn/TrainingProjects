package com.ignite.test;

import java.sql.SQLException;
import java.text.ParseException;

import com.ignite.beans.Employee;
import com.ignite.dao.EmployeeJdbcDao;

public class EmployeeInsertTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			EmployeeJdbcDao employeeJdbcDao = new EmployeeJdbcDao();
			Employee employee = new Employee("Kumar", "15-08-2000", 30, 8000);
			int empid = employeeJdbcDao.insert(employee);
			if(empid > 0) {
				System.out.println("Employee inserted successfully, with id : "+empid);
				employeeJdbcDao.save();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

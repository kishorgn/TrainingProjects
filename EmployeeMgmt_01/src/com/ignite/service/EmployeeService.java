package com.ignite.service;

import java.util.List;

import com.ignite.beans.Employee;
import com.ignite.exception.EmployeeException;

public interface EmployeeService {
	
	int save (Employee employee) throws EmployeeException;
	
	boolean update (Employee employee) throws EmployeeException;
	
	boolean delete (int id) throws EmployeeException;
	
	Employee find(int id) throws EmployeeException;
	
	List<Employee> findAll() throws EmployeeException;

}

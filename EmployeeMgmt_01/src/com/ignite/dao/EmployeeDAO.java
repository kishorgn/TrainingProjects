package com.ignite.dao;

import java.util.List;

import com.ignite.beans.Employee;

public interface EmployeeDAO {
	
	int insert(Employee employee) throws Exception ;
	
	boolean update(Employee employee) throws Exception;
	
	boolean delete(int id) throws Exception;
	
	Employee find(int id) throws Exception;
	
	List<Employee> findAll() throws Exception;

}

package com.ignite.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.ignite.beans.Employee;
import com.ignite.dao.EmployeeJdbcDao;
import com.ignite.exception.EmployeeException;

public class EmployeeDaoService implements EmployeeService {

	@Override
	public int save(Employee employee) throws EmployeeException {
		EmployeeJdbcDao employeeDAO = null;
		try {
			employeeDAO = new EmployeeJdbcDao();
			int empid = employeeDAO.insert(employee);
			return empid;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException("Class may not be found", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException("Problem with Database", e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new EmployeeException("Some internal problem", e);
		}
		finally {
			try {
				employeeDAO.save();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new EmployeeException("Problem with DB while comitting", e);
			}
		}
	}

	@Override
	public boolean update(Employee employee) throws EmployeeException {
		
		EmployeeJdbcDao employeeDAO = null;
		try {
			employeeDAO = new EmployeeJdbcDao();
			return employeeDAO.update(employee);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException("Class may not be found", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException("Problem with Database", e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new EmployeeException("Some internal problem", e);
		}
		finally {
			try {
				employeeDAO.save();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new EmployeeException("Problem with DB while comitting", e);
			}
		}
	}

	@Override
	public boolean delete(int id) throws EmployeeException {
		EmployeeJdbcDao employeeDAO = null;
		try {
			employeeDAO = new EmployeeJdbcDao();
			return employeeDAO.delete(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException("Class may not be found", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException("Problem with Database", e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new EmployeeException("Some internal problem", e);
		}
		finally {
			try {
				employeeDAO.save();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new EmployeeException("Problem with DB while comitting", e);
			}
		}
	}

	@Override
	public Employee find(int id) throws EmployeeException {
		EmployeeJdbcDao employeeDAO = null;
		try {
			employeeDAO = new EmployeeJdbcDao();
			return employeeDAO.find(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException("Class may not be found", e);
		} catch (SQLException e) {
			throw new EmployeeException("Problem with Database while parsing the DoB of employee with id "+id, e);
		} catch (ParseException e) {
			throw new EmployeeException("Unparssable id to find an employee "+id, e);
		}
		
	}

	@Override
	public List<Employee> findAll() throws EmployeeException {
		EmployeeJdbcDao employeeDAO = null;
		try {
			employeeDAO = new EmployeeJdbcDao();
			return employeeDAO.findAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException("Class may not be found", e);
		} catch (SQLException e) {
			throw new EmployeeException("Problem with Database while fetching employees", e);
		} catch (ParseException e) {
			throw new EmployeeException("Problem with Database while parsing the DoB of employee", e);
		}
	}

}

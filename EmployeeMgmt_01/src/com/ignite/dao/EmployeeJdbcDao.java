package com.ignite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ignite.beans.Employee;
import com.ignite.helper.ConnectionManager;

public class EmployeeJdbcDao extends Dao implements EmployeeDAO {

	public EmployeeJdbcDao() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(Employee employee) throws SQLException, ClassNotFoundException, ParseException {
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?)");
		int empid = getMaxId()+1 ;
		try {
			pstmt.setInt(1, empid);
			pstmt.setString(2, employee.getName());
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date dob = df.parse(employee.getDob());
			pstmt.setDate(3, new java.sql.Date(dob.getTime()));
			pstmt.setInt(4, employee.getDeptno());
			pstmt.setDouble(5, employee.getBsal());
			if(pstmt.executeUpdate()>0) {
				return empid;
			}
		}
		finally {
			pstmt.close();
		}
		
		return 0;
	}

	@Override
	public boolean update(Employee employee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = con.prepareStatement("UPDATE employee SET name = ?, dob = ?, deptno = ?, bsal = ? WHERE id = ?");
		try {
			pstmt.setString(1, employee.getName());
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date dob = df.parse(employee.getDob());
			pstmt.setDate(2, new java.sql.Date(dob.getTime()));
			pstmt.setInt(3, employee.getDeptno());
			pstmt.setDouble(4, employee.getBsal());
			pstmt.setInt(5, employee.getId());
			return 1==pstmt.executeUpdate() ;
		}
		finally {
			pstmt.close();
		}
	}

	@Override
	public boolean delete(int id) throws SQLException {
		Statement stmt = con.createStatement();
		try {
			return (1==stmt.executeUpdate("DELETE FROM employee WHERE id = "+id));
		}
		finally {
			stmt.close();
		}
	}

	@Override
	public Employee find(int id) throws SQLException, ParseException, ClassNotFoundException {
		Connection con = ConnectionManager.getConnection();
		con.commit();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employee WHERE id  = ?");
		ResultSet rs = null;
		Employee employee = null;
		try {
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString(2);
				java.sql.Date sqlDob = rs.getDate(3);
				Date utilDob = new Date(sqlDob.getTime());
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String strDob = df.format(utilDob);
				int deptno = rs.getInt(4);
				double bsal = rs.getDouble(5);
				employee = new Employee(name, strDob, deptno, bsal);
				employee.setId(id);
			}
			return employee;
		}
		finally {
			try {
				rs.close();
			}
			catch (SQLException e) {
				throw e;
			}
			try {
				pstmt.close();
			}
			catch (SQLException e) {
				throw e;
			}
			try {
				con.close();
			}
			catch (SQLException e) {
				throw e;
			}
			
		}
	}

	@Override
	public List<Employee> findAll() throws ClassNotFoundException, SQLException, ParseException {
		List<Employee> employees = new ArrayList<>();
		Connection con = ConnectionManager.getConnection();
		con.commit();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employee");
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				java.sql.Date sqlDob = rs.getDate(3);
				Date utilDob = new Date(sqlDob.getTime());
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String strDob = df.format(utilDob);
				int deptno = rs.getInt(4);
				double bsal = rs.getDouble(5);
				Employee employee = new Employee(name, strDob, deptno, bsal);
				employee.setId(id);
				employees.add(employee);
			}
			return employees;
		}
		finally {
			try {
				rs.close();
			}
			catch (SQLException e) {
				throw e;
			}
			try {
				pstmt.close();
			}
			catch (SQLException e) {
				throw e;
			}
			try {
				con.close();
			}
			catch (SQLException e) {
				throw e;
			}
			
		}
	}
	
	public int getMaxId() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			int maxId = 100 ;
			con = ConnectionManager.getConnection();
			con.commit();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT max(id) FROM employee");
			if(rs.next()) {
				maxId = rs.getInt(1);
				if(maxId == 0) {
					maxId = 100;
				}
			}
			return maxId;
		}
		finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				
			}
			catch (SQLException e) {
				throw e;
			}
			try {
				stmt.close();
			}
			catch (SQLException e) {
				throw e;
			}
			try {
				con.close();
			}
			catch (SQLException e) {
				throw e;
			}
			
		}
		
	}

}

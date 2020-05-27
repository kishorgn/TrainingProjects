package com.ignite.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.ignite.dao.EmployeeJdbcDao;

public class EmployeeJdbcDaoTest {

	@Test
	public void testGetMaxId() throws ClassNotFoundException, SQLException {
		EmployeeJdbcDao employeeJdbcDao = new EmployeeJdbcDao();
		assertEquals(100, employeeJdbcDao.getMaxId());
	}

}

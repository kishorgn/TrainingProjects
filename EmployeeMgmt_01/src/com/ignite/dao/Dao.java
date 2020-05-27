package com.ignite.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.ignite.helper.ConnectionManager;

public class Dao {

	protected Connection con;

	public Dao() throws ClassNotFoundException, SQLException{
		con = ConnectionManager.getConnection();
	}

	public void save() throws SQLException {
		try {
			con.commit();
		} catch (SQLException e) {
			throw e;
		}
		try {
			con.close();
		} catch (SQLException e) {
			throw e;
		}
	}

	public void undo() throws SQLException {
		try {
			con.rollback();
		} catch (SQLException e) {
			throw e;
		}
		try {
			con.close();
		} catch (SQLException e) {
			throw e;
		}
	}

}

package com.ignite.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String dri = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "kishor";
		String pass = "kishor";
		Connection con = null;
		Class.forName(dri);
		con = DriverManager.getConnection(url, user, pass);
		con.setAutoCommit(false);
		return con;

	}

}

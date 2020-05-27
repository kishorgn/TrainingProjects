package com.ignite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ignite.beans.Employee;
import com.ignite.beans.User;
import com.ignite.helper.ConnectionManager;

public class UserJdbcDao extends Dao implements UserDAO {

	public UserJdbcDao() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(User user) throws Exception {
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO employee VALUES(?,?,?)");
		int userid = getMaxId()+1 ;
		try {
			pstmt.setInt(1, userid);
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			if(pstmt.executeUpdate()>0) {
				return userid;
			}
		}
		finally {
			pstmt.close();
		}
		
		return 0;
	}

	@Override
	public boolean update(User user) throws Exception {
		PreparedStatement pstmt = con.prepareStatement("UPDATE user SET username=?, password=? WHERE id=?");
		try {
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getId());
			return 1==pstmt.executeUpdate() ;
		}
		finally {
			pstmt.close();
		}

	}

	@Override
	public boolean delete(int id) throws Exception {
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM user WHERE id=?");
		try {
			pstmt.setInt(1, id);
			return 1==pstmt.executeUpdate() ;
		}
		finally {
			pstmt.close();
		}
	}

	@Override
	public User find(int id) throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			User user = null;
			con = ConnectionManager.getConnection();
			con.commit();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user WHERE id="+id);
			if(rs.next()) {
				String username = rs.getString(2);
				String password = rs.getString(3);
				user = new User(username, password);
				user.setId(id);
			}
			return user;
		}
		finally {
			try {
				rs.close();
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

	@Override
	public List<User> findAll() throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<User> users= new ArrayList<User>();
		try {
			con = ConnectionManager.getConnection();
			con.commit();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user");
			while(rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				User user = new User(username, password);
				user.setId(id);
				users.add(user);
			}
			return users;
		}
		finally {
			try {
				rs.close();
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
	
	public static boolean validate(String username, String password) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			User user = null;
			con = ConnectionManager.getConnection();
			con.commit();
			pstmt = con.prepareStatement("SELECT * FROM user WHERE username = ? and password = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			return rs.next();
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
			rs = stmt.executeQuery("SELECT max(id) FROM user");
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
				rs.close();
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

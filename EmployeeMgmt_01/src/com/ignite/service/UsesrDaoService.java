package com.ignite.service;

import java.sql.SQLException;

import com.ignite.beans.User;
import com.ignite.dao.UserJdbcDao;
import com.ignite.exception.UserException;

public class UsesrDaoService implements UserService {

	@Override
	public int save(User user) throws UserException {
		UserJdbcDao userJdbcDao = null;
		try {
			userJdbcDao = new UserJdbcDao();
			int userid = userJdbcDao.insert(user);
			return userid;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new UserException("Class may not be found", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserException("Problem with Database", e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UserException("Some internal problem", e);
		}
		finally {
			try {
				userJdbcDao.save();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new UserException("Problem with DB while comitting", e);
			}
		}
	}

	@Override
	public boolean update(User user) throws UserException {
		UserJdbcDao userJdbcDao = null;
		try {
			userJdbcDao = new UserJdbcDao();
			return userJdbcDao.update(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new UserException("Class may not be found", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserException("Problem with Database", e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UserException("Some internal problem", e);
		}
		finally {
			try {
				userJdbcDao.save();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new UserException("Problem with DB while comitting", e);
			}
		}
	}
	
	public static boolean validate(String username, String password) throws UserException {
		
		try {
			return UserJdbcDao.validate(username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new UserException("Class may not be found", e);
		} catch (SQLException e) {
			throw new UserException("Problem with Database", e);
		} 
		finally {
			
		}
	}

}

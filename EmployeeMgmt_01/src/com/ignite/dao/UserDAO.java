package com.ignite.dao;

import java.util.List;

import com.ignite.beans.User;

public interface UserDAO {
	
int insert(User user) throws Exception ;
	
	boolean update(User user) throws Exception;
	
	boolean delete(int id) throws Exception;
	
	User find(int id) throws Exception;
	
	List<User> findAll() throws Exception;

}

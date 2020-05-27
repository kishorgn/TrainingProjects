package com.ignite.service;

import com.ignite.beans.User;
import com.ignite.exception.UserException;

public interface UserService {
	
	int save (User user) throws UserException;
	
	boolean update (User user) throws UserException;
	
}

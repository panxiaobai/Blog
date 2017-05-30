package com.white.service;

import com.white.dao.UserDAO;
import com.white.model.User;

public class UserService {

	private UserDAO userDAO=new UserDAO();
	
	public boolean login(User user){
		User u=userDAO.getUserByUsername(user.getUsername());
		if(u==null){
			return false;
		}else{
			if(u.getPassword().equals(user.getPassword())){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public boolean register(User user){
		if(userDAO.getUserByUsername(user.getUsername())==null){
			return userDAO.addUser(user);
		}else{
			return false;
		}
	}
	
	public boolean modifyUser(User user){
		return userDAO.modifyUser(user);
	}
	
	public User getUserById(String id){
		return userDAO.getUserById(id);
	}
	
	
}

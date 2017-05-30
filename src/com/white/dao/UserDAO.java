package com.white.dao;

import java.util.List;

import com.white.model.Blog;
import com.white.model.User;

public class UserDAO {
	public boolean addUser(User user){
		return true;
	}
	
	public boolean deleteUser(User user){
		return true;
	}
	
	public boolean modifyUser(User user){
		return true;
	}
	
	public User getUserById(String id){
		return null;
	}
	
	public User getUserByUsername(String username){
		return null;
	}
	
	public User getUserByBlog(Blog blog){
		return null;
	}
	
	public List<User> getAllUsers(){
		return null;
	}
	
	
}

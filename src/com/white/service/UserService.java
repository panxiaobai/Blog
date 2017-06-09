package com.white.service;

import com.white.dao.UserDAO;
import com.white.model.Blog;
import com.white.model.User;

public class UserService {

	
	public static User login(User user){
		User u=UserDAO.getUserByUsername(user.getUsername());
		if(u==null){
			return null;
		}else{
			if(u.getPassword().equals(user.getPassword())){
				return u;
			}else{
				return null;
			}
		}
	}
	
	public static boolean register(User user,Blog blog){
		if(UserDAO.getUserByUsername(user.getUsername())==null){
			return UserDAO.addUser(user)&&BlogService.addBlog(blog);
		}else{
			return false;
		}
	}
	
	public static boolean modifyUser(User user){
		return UserDAO.modifyUser(user);
	}
	
	public static User getUserById(int id){
		return UserDAO.getUserById(id);
	}
	
	public static boolean addUser(User user){
		return UserDAO.addUser(user);
	}
	
	
	
	
}

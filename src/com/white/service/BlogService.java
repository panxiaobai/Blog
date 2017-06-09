package com.white.service;

import com.white.dao.BlogDAO;
import com.white.model.Blog;
import com.white.model.User;

public class BlogService {
	
	public static boolean addBlog(Blog blog){
		return BlogDAO.addBlog(blog);
	}
	
	public static boolean deleteBlog(Blog blog){
		return BlogDAO.addBlog(blog);
	}
	
	public static boolean modifyBlog(Blog blog){
		return BlogDAO.modifyBlog(blog);
	}
	
	public static Blog getBlogById(int id){
		return BlogDAO.getBlogById(id);
	}
	
	public static Blog getBlogByUser(User user){
		return BlogDAO.getBlogByUser(user);
	}
}

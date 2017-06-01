package com.white.service;

import com.white.dao.BlogDAO;
import com.white.model.Blog;
import com.white.model.User;

public class BlogService {

	private BlogDAO blogDAO=new BlogDAO();
	
	public boolean addBlog(Blog blog){
		return blogDAO.addBlog(blog);
	}
	
	public boolean deleteBlog(Blog blog){
		return blogDAO.addBlog(blog);
	}
	
	public boolean modifyBlog(Blog blog){
		return blogDAO.modifyBlog(blog);
	}
	
	public Blog getBlogById(int id){
		return blogDAO.getBlogById(id);
	}
	
	public Blog getBlogByUser(User user){
		return blogDAO.getBlogByUser(user);
	}
}

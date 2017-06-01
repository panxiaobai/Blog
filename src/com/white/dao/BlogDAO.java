package com.white.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.white.model.Blog;
import com.white.model.User;
import com.white.util.MySession;

public class BlogDAO {

	public Session session=MySession.session;
	
	public boolean addBlog(Blog blog){
		Transaction tr = session.beginTransaction();
		session.save(blog);
		tr.commit();
		return true;
	}
	
	public boolean deleteBlog(Blog blog){
		Transaction tr = session.beginTransaction();
		session.delete(blog);
		tr.commit();
		return true;
	}
	
	public boolean modifyBlog(Blog blog){
		Transaction tr = session.beginTransaction();
		session.update(blog);
		tr.commit();
		return true;
	}
	
	public Blog getBlogById(int id){
		Transaction tr = session.beginTransaction();
		Blog blog=session.load(Blog.class, id);
		tr.commit();
		return blog;
	}
	
	public Blog getBlogByUser(User user){
		Transaction tr = session.beginTransaction();
		String hql = "from blog_blog where user=?";  
        Query query = session.createQuery(hql).setParameter(0, user.getId());  
		List<Blog> blogs=query.list();
		tr.commit();
		if(blogs==null||blogs.size()==0){
			return null;
		}else{
			return blogs.get(0);
		}
	}
	
	public List<Blog> getAllBlogs(){
		Transaction tr = session.beginTransaction();
		String hql = "from blog_blog";  
        Query query = session.createQuery(hql);  
		List<Blog> blogs=query.list();
		tr.commit();
		if(blogs==null||blogs.size()==0){
			return null;
		}else{
			return blogs;
		}
	}
	
}

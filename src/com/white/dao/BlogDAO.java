package com.white.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.white.model.Blog;
import com.white.model.User;
import com.white.util.MySession;

public class BlogDAO {

	public static Session session=MySession.session;
	
	public static boolean addBlog(Blog blog){
		Transaction tr = session.beginTransaction();
		session.save(blog);
		tr.commit();
		return true;
	}
	
	public static boolean deleteBlog(Blog blog){
		Transaction tr = session.beginTransaction();
		session.delete(blog);
		tr.commit();
		return true;
	}
	
	public static boolean modifyBlog(Blog blog){
		Transaction tr = session.beginTransaction();
		session.update(blog);
		tr.commit();
		return true;
	}
	
	public static Blog getBlogById(int id){
		Transaction tr = session.beginTransaction();
		Blog blog=session.get(Blog.class, id);
		tr.commit();
		return blog;
	}
	
	public static Blog getBlogByUser(User user){
		Transaction tr = session.beginTransaction();
		String hql = "from blog_blog where user_id=?";  
        Query query = session.createQuery(hql).setParameter(0, user.getId());  
		List<Blog> blogs=query.list();
		tr.commit();
		if(blogs==null||blogs.size()==0){
			return null;
		}else{
			return blogs.get(0);
		}
	}
	
	public static List<Blog> getAllBlogs(){
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

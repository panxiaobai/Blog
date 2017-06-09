package com.white.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.white.model.Blog;
import com.white.model.User;
import com.white.util.MySession;

public class UserDAO {
	
	
	public static Session session=MySession.session;
	
	public static boolean addUser(User user){
		Transaction tr = session.beginTransaction();
		session.save(user);
		tr.commit();
		return true;
	}
	
	public static boolean deleteUser(User user){
		Transaction tr = session.beginTransaction();
		session.delete(user);
		tr.commit();
		return true;
	}
	
	public static boolean modifyUser(User user){
		Transaction tr = session.beginTransaction();
		session.update(user);
		tr.commit();
		return true;
	}
	
	public static User getUserById(int id){
		Transaction tr = session.beginTransaction();
		User user=session.get(User.class, id);
		tr.commit();
		return user;
	}
	
	public static User getUserByUsername(String username){
		Transaction tr = session.beginTransaction();
		String hql = "from blog_user where username=?";  
        Query query = session.createQuery(hql).setParameter(0, username);  
		List<User> users=query.list();
		tr.commit();
		if(users==null||users.size()==0){
			return null;
		}else{
			return users.get(0);
		}
	}
	
	public static User getUserByBlog(Blog blog){
		Transaction tr = session.beginTransaction();
		String hql = "from blog_user where blog=?";  
        Query query = session.createQuery(hql).setParameter(0, blog.getId());  
		List<User> users=query.list();
		tr.commit();
		if(users==null||users.size()==0){
			return null;
		}else{
			return users.get(0);
		}
	}
	
	public static List<User> getAllUsers(){
		Transaction tr = session.beginTransaction();
		String hql = "from blog_user";  
        Query query = session.createQuery(hql);  
		List<User> users=query.list();
		tr.commit();
		if(users==null||users.size()==0){
			return null;
		}else{
			return users;
		}
	}
	
	
}

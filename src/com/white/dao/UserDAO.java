package com.white.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.white.model.Blog;
import com.white.model.User;
import com.white.util.MySession;

public class UserDAO {
	
	public Session session=MySession.session;
	
	public boolean addUser(User user){
		Transaction tr = session.beginTransaction();
		session.save(user);
		tr.commit();
		return true;
	}
	
	public boolean deleteUser(User user){
		Transaction tr = session.beginTransaction();
		session.delete(user);
		tr.commit();
		return true;
	}
	
	public boolean modifyUser(User user){
		Transaction tr = session.beginTransaction();
		session.update(user);
		tr.commit();
		return true;
	}
	
	public User getUserById(int id){
		Transaction tr = session.beginTransaction();
		User user=session.load(User.class, id);
		tr.commit();
		return user;
	}
	
	public User getUserByUsername(String username){
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
	
	public User getUserByBlog(Blog blog){
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
	
	public List<User> getAllUsers(){
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

package com.white.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.white.model.Blog;
import com.white.model.Essay;
import com.white.model.User;
import com.white.util.MySession;

public class EssayDAO {
	
	public Session session=MySession.session;
	
	public boolean addEssay(Essay essay){
		Transaction tr = session.beginTransaction();
		session.save(essay);
		tr.commit();
		return true;
	}
	
	public boolean deleteEssay(Essay essay){
		Transaction tr = session.beginTransaction();
		session.delete(essay);
		tr.commit();
		return true;
	}
	
	public boolean modifyEssay(Essay essay){
		Transaction tr = session.beginTransaction();
		session.update(essay);
		tr.commit();
		return true;
	}
	
	public Essay getEssayById(int id){
		Transaction tr = session.beginTransaction();
		Essay essay=session.load(Essay.class, id);
		tr.commit();
		return essay;
	}
	
	public Essay getEssayByTitle(String title){
		Transaction tr = session.beginTransaction();
		String hql = "from blog_essay where title=?";  
        Query query = session.createQuery(hql).setParameter(0, title);  
		List<Essay> essays=query.list();
		tr.commit();
		if(essays==null||essays.size()==0){
			return null;
		}else{
			return essays.get(0);
		}
	}
	
	public List<Essay> getEssaysByBlog(Blog blog){
		Transaction tr = session.beginTransaction();
		String hql = "from blog_essay where blog=?";  
        Query query = session.createQuery(hql).setParameter(0, blog.getId());  
		List<Essay> essays=query.list();
		tr.commit();
		if(essays==null||essays.size()==0){
			return null;
		}else{
			return essays;
		}
	}
	
	public List<Essay> getEssaysByUser(User user){
		return null;
	}
	
	public List<Essay> getEssaysLikeTitle(String title){
		Transaction tr = session.beginTransaction();
		String hql = "from blog_essay where title like ?";  
        Query query = session.createQuery(hql).setParameter(0, title);  
		List<Essay> essays=query.list();
		tr.commit();
		if(essays==null||essays.size()==0){
			return null;
		}else{
			return essays;
		}
	}
}

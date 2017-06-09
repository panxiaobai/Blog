package com.white.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.white.model.Admin;
import com.white.model.User;
import com.white.util.MySession;

public class AdminDAO {
	
	public static Session session=MySession.session;
	
	public static boolean addAdmin(Admin admin){
		Transaction tr = session.beginTransaction();
		session.save(admin);
		tr.commit();
		return true;
	}
	
	public static boolean deleteAdmin(Admin admin){
		return true;
	}
	
	public static boolean modifyAdmin(Admin admin){
		Transaction tr = session.beginTransaction();
		session.delete(admin);
		tr.commit();
		return true;
	}
	
	public static Admin getAdminByUsername(String username){
		Transaction tr = session.beginTransaction();
		String hql = "from blog_admin where username=?";  
        Query query = session.createQuery(hql).setParameter(0, username);  
		List<Admin> admins=query.list();
		tr.commit();
		if(admins==null||admins.size()==0){
			return null;
		}else{
			return admins.get(0);
		}
	}
	
	public static List<Admin> getAllAdmins(){
		Transaction tr = session.beginTransaction();
		String hql = "from blog_admin";  
        Query query = session.createQuery(hql);  
		List<Admin> admins=query.list();
		tr.commit();
		if(admins==null||admins.size()==0){
			return null;
		}else{
			return admins;
		}
	}
}

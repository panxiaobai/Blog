package com.white.service;

import com.white.dao.AdminDAO;
import com.white.model.Admin;

public class AdminService {

	
	public static boolean login(Admin admin){
		Admin a=AdminDAO.getAdminByUsername(admin.getUsername());
		if(a==null){
			return false;
		}else{
			if(a.getPassword().equals(admin.getPassword())){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public static boolean addAdmin(Admin admin){
		return AdminDAO.addAdmin(admin);
	}
	
	public static boolean deleteAdmin(Admin admin){
		return AdminDAO.deleteAdmin(admin);
	}
	
	
}

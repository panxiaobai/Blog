package com.white.service;

import com.white.dao.AdminDAO;
import com.white.model.Admin;

public class AdminService {

	private AdminDAO adminDAO=new AdminDAO();
	
	public boolean login(Admin admin){
		Admin a=adminDAO.getAdminByUsername(admin.getUsername());
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
	
	public boolean deleteAdmin(Admin admin){
		return adminDAO.deleteAdmin(admin);
	}
	
	
}

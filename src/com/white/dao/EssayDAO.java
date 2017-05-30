package com.white.dao;

import java.util.List;

import com.white.model.Blog;
import com.white.model.Essay;
import com.white.model.User;

public class EssayDAO {

	public boolean addEssay(Essay essay){
		return true;
	}
	
	public boolean deleteEssay(Essay essay){
		return true;
	}
	
	public boolean modifyEssay(Essay essay){
		return true;
	}
	
	public Essay getEssayById(String id){
		return null;
	}
	
	public Essay getEssayByTitle(String title){
		return null;
	}
	
	public List<Essay> getEssaysByBlog(Blog blog){
		return null;
	}
	
	public List<Essay> getEssaysByUser(User user){
		return null;
	}
}

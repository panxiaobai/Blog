package com.white.service;

import java.util.List;

import com.white.dao.EssayDAO;
import com.white.model.Blog;
import com.white.model.Essay;
import com.white.model.User;

public class EssayService {

	private EssayDAO essayDAO=new EssayDAO();
	
	public boolean addEssay(Essay essay){
		return essayDAO.addEssay(essay);
	}
	
	public boolean deleteEssay(Essay essay){
		return essayDAO.deleteEssay(essay);
	}
	
	public boolean modifyEssay(Essay essay){
		return essayDAO.modifyEssay(essay);
	}
	
	public Essay getEssayById(int id){
		return essayDAO.getEssayById(id);
	}
	
	public Essay getEssayByTitle(String title){
		return essayDAO.getEssayByTitle(title);
	}
	
	public List<Essay> getEssaysByBlog(Blog blog){
		return essayDAO.getEssaysByBlog(blog);
	}
	
	public List<Essay> getEssaysLikeTitle(String title){
		return essayDAO.getEssaysLikeTitle(title);
	}
	
	public List<Essay> getEssaysByUser(User user){
		return essayDAO.getEssaysByUser(user);
	}
}

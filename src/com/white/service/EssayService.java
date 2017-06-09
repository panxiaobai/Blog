package com.white.service;

import java.util.List;

import com.white.dao.EssayDAO;
import com.white.model.Blog;
import com.white.model.Essay;
import com.white.model.User;

public class EssayService {

	
	public static boolean addEssay(Essay essay){
		return EssayDAO.addEssay(essay);
	}
	
	public static boolean deleteEssay(Essay essay){
		return EssayDAO.deleteEssay(essay);
	}
	
	public static boolean modifyEssay(Essay essay){
		return EssayDAO.modifyEssay(essay);
	}
	
	public static Essay getEssayById(int id){
		return EssayDAO.getEssayById(id);
	}
	
	public static Essay getEssayByTitle(String title){
		return EssayDAO.getEssayByTitle(title);
	}
	
	public static List<Essay> getEssaysByBlog(Blog blog){
		return EssayDAO.getEssaysByBlog(blog);
	}
	
	public static List<Essay> getEssaysLikeTitle(String title){
		return EssayDAO.getEssaysLikeTitle(title);
	}
	
	public static List<Essay> getEssaysByUser(User user){
		return EssayDAO.getEssaysByUser(user);
	}
}

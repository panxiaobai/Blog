package com.white.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.white.dao.BlogDAO;
import com.white.dao.UserDAO;
import com.white.model.Blog;
import com.white.model.Essay;
import com.white.model.User;
import com.white.service.BlogService;
import com.white.service.EssayService;
import com.white.service.UserService;

public class TestMain {

	public static void main(String[] args){
		
		User user=new User();
		Blog blog=new Blog();
		user.setName("潘小白");
		user.setPassword("panyu");
		user.setPassword("880412");
		user.setDescription("panxiaobai");
		blog.setName("潘小白的博客");
		blog.setDescription("panxiaobai blog");
		blog.setUser(user);
		user.setBlog(blog);
		Essay essay=new Essay();
		essay.setBlog(blog);
		essay.setDate(new Date());
		essay.setTitle("潘小白的第一篇文章");
		essay.setType("general");
		essay.setDescript("panxiaobai first essay");
		essay.setContent("It is my first blog");
		essay.setPraiseNum(520);
		UserService.addUser(user);
		BlogService.addBlog(blog);
		EssayService.addEssay(essay);

	}
}

package com.white.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.white.dao.UserDAO;
import com.white.model.User;

public class TestMain {

	public static void main(String[] args){
		/*
		try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
        }catch(ClassNotFoundException e1){
            System.out.println("找不到MySQL驱动!");
            e1.printStackTrace();
        }
        
        String url="jdbc:mysql://localhost:3306/mysql";    //JDBC的URL    
        //调用DriverManager对象的getConnection()方法，获得一个Connection对象
        Connection conn;
        try {
            conn = DriverManager.getConnection(url,"root","");
            //创建一个Statement对象
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库！");
            System.out.println(stmt.execute("create database test2;"));
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        */
		
		UserDAO userDao=new UserDAO();
		User user=new User();
		user.setUsername("gewhrh");
		userDao.addUser(user);
		User u1=userDao.getUserByUsername("gewhrh");
		User u2=userDao.getUserById(2);
		System.out.println(u1.getUsername());
		System.out.println(u2.getUsername());

	}
}

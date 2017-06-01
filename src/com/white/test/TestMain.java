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
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL������");
        }catch(ClassNotFoundException e1){
            System.out.println("�Ҳ���MySQL����!");
            e1.printStackTrace();
        }
        
        String url="jdbc:mysql://localhost:3306/mysql";    //JDBC��URL    
        //����DriverManager�����getConnection()���������һ��Connection����
        Connection conn;
        try {
            conn = DriverManager.getConnection(url,"root","");
            //����һ��Statement����
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ⣡");
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

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
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	    //2. ���ݷ���ע���ഴ��һ��Ԫ������Դ����ͬʱ����Ԫ���ݲ�����Ӧ��һ��Ψһ�ĵ�session����
	    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

	    /****����������׼�������濪ʼ���ǵ����ݿ����******/
	    Session session = sessionFactory.openSession();//�ӻỰ������ȡһ��session

	}
}

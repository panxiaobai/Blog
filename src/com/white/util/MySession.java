package com.white.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MySession {

	public static Session session;
	
	static{
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	    //2. ���ݷ���ע���ഴ��һ��Ԫ������Դ����ͬʱ����Ԫ���ݲ�����Ӧ��һ��Ψһ�ĵ�session����
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

	    /****����������׼�������濪ʼ���ǵ����ݿ����******/
	    session = sessionFactory.openSession();//�ӻỰ������ȡһ��session
	}
}

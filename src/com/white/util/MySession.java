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
	    //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

	    /****上面是配置准备，下面开始我们的数据库操作******/
	    session = sessionFactory.openSession();//从会话工厂获取一个session
	}
}

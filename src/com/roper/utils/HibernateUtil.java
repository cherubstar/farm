package com.roper.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil{
	
    public static final SessionFactory sessionFactory;
    static{
        Configuration config = new AnnotationConfiguration().configure();
        sessionFactory = config.buildSessionFactory();
    }
    /**
     * 获得一个SessionFactory对象
     */
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
    /**
     * 获取一个Session会话
     */
    public static Session getSession(){
        return sessionFactory.openSession();   //打开session
    }
    /**
     * 关闭Session会话连接
     */
    public static void closeSession(Session session){
        if(session != null){
            session.close();
        }
    }
    /**
     * 关闭SessionFactory
     */
    public static void closeResource(Session session){
    	session.close();
    	sessionFactory.close();
    }
}
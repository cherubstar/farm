package com.roper.utils;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.roper.api.CRUDData;

public class CRUDDataUtil<T> implements CRUDData<T>{

	private Class<T> classType;
	private String userName;
	
	public CRUDDataUtil(Class<T> classType) {
		super();
		this.classType = classType;
	}
	
	public CRUDDataUtil(Class<T> classType, String userName) {
		super();
		this.classType = classType;
		this.userName = userName;
	}

	/**
	 * 添加用户
	 */
	public static void save(Object object) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
//		session.save(object);
		session.saveOrUpdate(object);
		tx.commit();
		HibernateUtil.closeResource(session);
		
	}
	
	/**
	 * 删除
	 */
	public static void delete(Object object) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(object);
		tx.commit();
		HibernateUtil.closeResource(session);
		
	}
	/**
	 * 通过用户名删除
	 */
	@Override
	public void deleteByUserName(String userName) {
		
		System.out.println("转换成unicode的用户: " +userName);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(classType);
		Criterion criterion = Restrictions.eq("username", userName);
		criteria.add(criterion);
		List<T> list = criteria.list();
		T t = null;
		for (T d : list) {
			if (d != null) {
				t = d;
			}
		}
		session.delete(t);
		tx.commit();
		HibernateUtil.closeResource(session);
		
	}
	
	/**
	 * 通过用户Id删除
	 */
	@Override
	public void deleteByUserId(Integer id) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(classType);
		Criterion criterion = Restrictions.eq("id", id);
		criteria.add(criterion);
		List<T> list = criteria.list();
		T t = null;
		for (T d : list) {
			if (d != null) {
				t = d;
			}
		}
		session.delete(t);
		tx.commit();
		HibernateUtil.closeResource(session);
		
	}
	
	/**
	 * 查询数据
	 */
	@Override
	public T query(Object...index) {
		
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(classType);
		if(index[0] == ""){
			
		}else{
			criteria.add(Restrictions.eq("id", index[0]));
		}
//		criteria.add(Restrictions.eq("id", (Integer)index[0]));
		List<T> list = criteria.list();
//		T t = classType.newInstance();
		T t = null;
		for (T d : list) {
			if (d != null) {
				t = d;
			}
		}
		HibernateUtil.closeResource(session);
		return t;
	}
	
	@Override
	public T queryByUserName() {
		
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(classType);
		criteria.add(Restrictions.eq("username", userName));
		List<T> list = criteria.list();
		T t = null;
		for (T d : list) {
			if (d != null) {
				t = d;
			}
		}
		HibernateUtil.closeResource(session);
		return t;
	}
	
	@Override
	public List<T> queryAllByUserName() {
		
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(classType);
		List<T> list = criteria.list();
		HibernateUtil.closeResource(session);
		
		return list;
	}
	
	public static void update() {
		
	}
}
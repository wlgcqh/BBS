package com.qiheng.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.qiheng.DAO.GroudDAO;
import com.qiheng.bean.Groud;
import com.qiheng.bean.Plate;

public class GroudDAOImpl implements GroudDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Groud findGroudNameAndPlateName(int groudId) {
		
		Session session = getSession();
		
		return (Groud) session.get(Groud.class, groudId);
		
		
	}

	public List<Plate> findAllPlate() {
		Session session = getSession();
		
		List<Plate> list = session.createQuery("from Plate").list();
		return list;
	}

	

}

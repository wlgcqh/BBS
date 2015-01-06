package com.qiheng.DAO.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.qiheng.DAO.AdminDAO;
import com.qiheng.bean.Admin;

public class AdminDAOImpl implements AdminDAO {

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

	public void save(Admin admin) {
		Session session = getSession();

		session.save(admin);

	}

	public Admin listOne(int userId) {
		Session session = getSession();

		Admin admin = (Admin) session.createQuery("from Admin a where a.user.id = :userId")
				.setInteger("userId", userId).uniqueResult();
		return admin;
	}

}

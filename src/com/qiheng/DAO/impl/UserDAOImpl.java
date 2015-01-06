package com.qiheng.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.qiheng.DAO.UserDAO;
import com.qiheng.bean.User;

public class UserDAOImpl implements UserDAO {

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

	public void save(User u) {
		Session session = getSession();

		session.save(u);

	}

	public boolean checkUserExistByName(String username) {
		Session session = getSession();

		List<User> list = session
				.createQuery("from User as u where u.username = :name")
				.setString("name", username).list();

		if (null != list && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List list(int offiset) {
		
		Session session = getSession();
		List list=session.createQuery("from User")
				.setFirstResult((offiset-1)*10)
				.setMaxResults(10)
				.list();
			return list;
	}

	public User listOne(int userId) {

		Session session = getSession();

		
		User user = (User) session
				.createQuery("from User as u where u.id = :id")
				.setInteger("id", userId).uniqueResult();

		return user;
	}

	public int findUserIdByName(String username) {

		Session session = getSession();

		User user = (User) session
				.createQuery("from User as u where u.username = :name")
				.setString("name", username).uniqueResult();

		return user.getId();
	}

	public boolean checkUsernameAndPassword(String username, String password) {

		Session session = getSession();

		List<User> list = session
				.createQuery(
						"from User u where u.username = :name and u.password = :password")
				.setString("name", username).setString("password", password)
				.list();

		if (null != list && list.size() > 0) {
			return true;
		}
		return false;
	}

	public void update(User user) {
		Session session = getSession();
		session.update(user);

	}

	public int getUserCount() {
		
		Session session = getSession();
		Long count = (Long) session
				.createQuery(
						"select count(*) from User")
				.uniqueResult();
		return count.intValue();
	}

	public void userDelete(User user) {
		Session session = getSession();
		
		session.delete(user);

	}

	public User findUserNameAndPlateName(int userId) {
		Session session = getSession();

		return (User) session.get(User.class, userId);
	}

	public boolean checkUserExistExceptUser(User user) {
		Session session = getSession();

		List<User> list = session
				.createQuery(
						"from User as u where u.username = :name and u.id != :id")
				.setString("name", user.getUsername())
				.setInteger("id", user.getId()).list();

		if (null != list && list.size() > 0) {
			return true;
		}
		return false;
	}

}

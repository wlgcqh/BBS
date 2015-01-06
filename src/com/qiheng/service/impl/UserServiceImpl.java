package com.qiheng.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qiheng.DAO.UserDAO;
import com.qiheng.bean.User;
import com.qiheng.service.UserService;
@Transactional
public class UserServiceImpl implements UserService {

	private UserDAO dao;

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	public boolean exist(User u) throws Exception {
		return dao.checkUserExistByName(u.getUsername());
		
	}

	public void add(User u) throws Exception {
		dao.save(u);
		
	}

	public List<User> list(int offiset) {

		return dao.list(offiset);
	}

	public User listOne(String username) {
		return dao.listOne(dao.findUserIdByName(username));
	}

	public boolean login(User u) throws Exception {
		
		return dao.checkUsernameAndPassword(u.getUsername(), u.getPassword());
	}

	public void update(User user) {
		dao.update(user);
		
	}

	public int getUserCount() {

		return dao.getUserCount();
	}

	public void delete(User user) {
		dao.userDelete(user);
		
	}

	public User getInfo(int userId) {
		
		return dao.listOne(userId);
	}

	public User findUser(int userId) {
		// TODO Auto-generated method stub
		return dao.findUserNameAndPlateName(userId);
	}

	public boolean existExceptUser(User user) {
		
		return dao.checkUserExistExceptUser(user);
	}

	

}

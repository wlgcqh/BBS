package com.qiheng.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.qiheng.DAO.AdminDAO;
import com.qiheng.bean.Admin;
import com.qiheng.service.AdminService;
@Transactional
public class AdminServiceImpl implements AdminService {
	
	private AdminDAO dao;
	

	public AdminDAO getDao() {
		return dao;
	}

	public void setDao(AdminDAO dao) {
		this.dao = dao;
	}

	public void add(Admin admin) {
		dao.save(admin);

	}

	public Admin find(int userId) {

		return dao.listOne(userId);
	}

}

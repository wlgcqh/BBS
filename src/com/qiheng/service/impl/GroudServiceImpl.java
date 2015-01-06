package com.qiheng.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;


import com.qiheng.DAO.GroudDAO;
import com.qiheng.bean.Groud;
import com.qiheng.bean.Plate;
import com.qiheng.service.GroudService;

@Transactional
public class GroudServiceImpl implements GroudService{

	private GroudDAO groudDao;
	
	
	public GroudDAO getGroudDao() {
		return groudDao;
	}

	public void setGroudDao(GroudDAO groudDao) {
		this.groudDao = groudDao;
	}

	public Groud findGroud(int groudId) {
		
		return this.groudDao.findGroudNameAndPlateName(groudId);
	}

	public List<Plate> findAllPlate() {
		
		return this.groudDao.findAllPlate();
	}

	




}

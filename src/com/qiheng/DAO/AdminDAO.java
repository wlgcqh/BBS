package com.qiheng.DAO;

import com.qiheng.bean.Admin;


public interface AdminDAO {

	public void save(Admin admin);

	public Admin listOne(int userId);
	
}

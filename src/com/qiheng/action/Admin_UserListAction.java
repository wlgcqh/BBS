package com.qiheng.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qiheng.bean.Admin;
import com.qiheng.bean.Groud;
import com.qiheng.bean.Plate;
import com.qiheng.bean.User;
import com.qiheng.info.AdminInfo;
import com.qiheng.info.UserInfo;
import com.qiheng.service.AdminService;
import com.qiheng.service.GroudService;
import com.qiheng.service.UserService;

public class Admin_UserListAction extends ActionSupport implements
		ModelDriven<AdminInfo> {

	private AdminInfo adminInfo = new AdminInfo();
	private GroudService groudService;
	private UserService userService;
	private AdminService adminService;
	private List<Plate> plates;
	private User user;
	private Admin admin;
	private Plate plate;
	private int page;
	private List<User> users;

	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();

	@Override
	public String execute() throws Exception {

		int count = userService.getUserCount();
		page = count % 10 == 0 ? count/10 : count/10 + 1;
		users = userService.list(adminInfo.getOffiset());
		
		return SUCCESS;
		
	}

	public AdminInfo getModel() {
		// TODO Auto-generated method stub
		return adminInfo;
	}

	public AdminInfo getAdminInfo() {
		return adminInfo;
	}

	public void setAdminInfo(AdminInfo adminInfo) {
		this.adminInfo = adminInfo;
	}

	public GroudService getGroudService() {
		return groudService;
	}

	public void setGroudService(GroudService groudService) {
		this.groudService = groudService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Plate> getPlates() {
		return plates;
	}

	public void setPlates(List<Plate> plates) {
		this.plates = plates;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Plate getPlate() {
		return plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}

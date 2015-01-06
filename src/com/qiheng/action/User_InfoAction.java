package com.qiheng.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qiheng.bean.User;
import com.qiheng.info.UserInfo;
import com.qiheng.service.UserService;

public class User_InfoAction extends ActionSupport implements ModelDriven<UserInfo> {
	private UserInfo userInfo = new UserInfo();

	private User user;

	private UserService userService;
	
	Map session = ActionContext.getContext().getSession();

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserInfo getModel() {
		// TODO Auto-generated method stub
		return userInfo;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(userInfo.getUserId());

		user = userService.getInfo((Integer)session.get("userId"));
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
//		System.out.println(user.getSex());
		return SUCCESS;
		
	}
}

package com.qiheng.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qiheng.bean.User;
import com.qiheng.info.UserInfo;
import com.qiheng.service.UserService;

public class User_UpdateAction extends ActionSupport implements
		ModelDriven<UserInfo> {

	private UserInfo userInfo = new UserInfo();

	private User user;

	private UserService userService;

	Map session = ActionContext.getContext().getSession();
	
	@Override
	public String execute() throws Exception {

		user = userService.listOne((String) session.get("username"));
		user.setUsername(userInfo.getUsername());
		user.setAddress(userInfo.getAddress());
		user.setAnswer(userInfo.getAnswer());
		user.setEmail(userInfo.getEmail());
		user.setIdiograph(userInfo.getIdiograph());
		user.setIsOpen(userInfo.getIsopen());
		user.setPassword(userInfo.getPassword1());
		user.setQq(userInfo.getQq());
		user.setQuestion(userInfo.getQuestion());
		user.setRealname(userInfo.getRealname());
		user.setSex(userInfo.getSex());
		user.setBirthday(userInfo.getBirthday());
		if (userService.existExceptUser(user)) {
			return ERROR;
		} else {
			userService.update(user);
			return SUCCESS;
		}

	}
	

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
		return userInfo;
	}

	

}

package com.qiheng.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qiheng.bean.Admin;
import com.qiheng.bean.Groud;
import com.qiheng.bean.Plate;
import com.qiheng.bean.Post;
import com.qiheng.bean.User;
import com.qiheng.info.AdminInfo;
import com.qiheng.info.UserInfo;
import com.qiheng.service.AdminService;
import com.qiheng.service.GroudService;
import com.qiheng.service.PostService;
import com.qiheng.service.UserService;

public class Admin_PostDeleteAction extends ActionSupport implements
		ModelDriven<AdminInfo> {

	private AdminInfo adminInfo = new AdminInfo();
	private GroudService groudService;
	private UserService userService;
	private AdminService adminService;
	private PostService postService;
	private List<Plate> plates;
	private List<Post> posts;
	private User user;
	private Post post;
	private Admin admin;
	private Plate plate;
	private int page;

	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();

	@Override
	public String execute() throws Exception {

		post = new Post();
		post.setId(adminInfo.getPostId());
		postService.delete(post);

		return SUCCESS;
		
	}

	public AdminInfo getModel() {

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

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}

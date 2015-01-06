package com.qiheng.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qiheng.bean.Groud;
import com.qiheng.bean.Post;
import com.qiheng.bean.Reply;
import com.qiheng.bean.User;
import com.qiheng.info.PostInfo;
import com.qiheng.info.UserInfo;
import com.qiheng.service.GroudService;
import com.qiheng.service.PostService;
import com.qiheng.service.UserService;

public class Post_UserlistAction extends ActionSupport implements ModelDriven<PostInfo> {

	private List<Post> posts;
	private PostInfo postInfo = new PostInfo();
	private UserInfo userInfo = new UserInfo();
	private PostService postService;
	private GroudService groudService;
	private UserService userService;
	private Groud groud;
	private int page;
	private Post post;
	private User user;
	private List<Reply> replys;

	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	public PostInfo getModel() {

		return postInfo;
	}
	@Override
	public String execute() throws Exception {

		int userId = (Integer) session.get("userId");
		user = userService.findUser(userId);
		
		posts = postService.userlist(postInfo.getOffiset(), user.getId());// 根据userID列出帖子、分页
//		session.put("userId", postInfo.getUserId());
		int count = posts.size();// 记录总数
		page = count % 10 == 0 ? count / 10 : count / 10 + 1;// 页数
		return SUCCESS;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public PostInfo getPostInfo() {
		return postInfo;
	}
	public void setPostInfo(PostInfo postInfo) {
		this.postInfo = postInfo;
	}
	public PostService getPostService() {
		return postService;
	}
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	public GroudService getGroudService() {
		return groudService;
	}
	public void setGroudService(GroudService groudService) {
		this.groudService = groudService;
	}
	public Groud getGroud() {
		return groud;
	}
	public void setGroud(Groud groud) {
		this.groud = groud;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Reply> getReplys() {
		return replys;
	}
	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}

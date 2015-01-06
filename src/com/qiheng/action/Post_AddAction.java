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
import com.qiheng.service.GroudService;
import com.qiheng.service.PostService;
import com.qiheng.service.UserService;

public class Post_AddAction extends ActionSupport implements
		ModelDriven<PostInfo> {

	private List<Post> posts;
	private PostInfo postInfo = new PostInfo();
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
	
	@Override
	public String execute() throws Exception {
		
		user = new User();
		user.setId((Integer) session.get("userId"));
		groud = new Groud();
		groud.setId((Integer) session.get("groudId"));
		post = new Post();
		post.setTitle(postInfo.getTitle());
		post.setContext(postInfo.getContext());
		post.setCreateTime(postInfo.getNowTime());
		post.setUser(user);
		post.setGroud(groud);
		postService.add(post);
		User u = userService.listOne((String) session.get("username"));
		
		u.setScore(u.getScore() + 5);// 发帖加5分
		u.setPostTime(u.getPostTime() + 1);//发帖数加1
		userService.update(u);
		
		return SUCCESS;
	}
	public PostInfo getModel() {
		// TODO Auto-generated method stub
		return postInfo;
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
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
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

}

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

public class Post_ReplyAction extends ActionSupport implements
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
	private Reply reply;
	private List<Reply> replys;

	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	
	@Override
	public String execute() throws Exception {
		
		reply = new Reply();
		user = new User();
		post = new Post();
		post.setId(postInfo.getPostId());
		user.setId((Integer) session.get("userId"));
		reply.setUser(user);
		reply.setPost(post);
		reply.setContext(postInfo.getContext());
		reply.setReplyTime(postInfo.getNowTime());
		postService.addReply(reply);
		Post p = postService.listOne(postInfo.getPostId());
		User u = userService.listOne((String) session.get("username"));
		u.setScore(u.getScore() + 1);//积分加1
		u.setReplyTime(u.getReplyTime() + 1);//用户回复次数加1
		p.setReplyTime(p.getReplyTime() + 1);//帖子回复次数加一
		postService.updatePost(p);
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
	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
		this.reply = reply;
	}

}

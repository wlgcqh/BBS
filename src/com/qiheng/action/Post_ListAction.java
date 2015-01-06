package com.qiheng.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qiheng.bean.Groud;
import com.qiheng.bean.Plate;
import com.qiheng.bean.Post;
import com.qiheng.info.PostInfo;
import com.qiheng.service.GroudService;
import com.qiheng.service.PostService;

public class Post_ListAction extends ActionSupport implements
		ModelDriven<PostInfo> {

	private List<Post> posts;
	private PostInfo postInfo = new PostInfo();
	private PostService postService;
	private GroudService groudService;
	private Groud groud;
	private Plate plate;
	private int page;

	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {

		posts = postService.listAndPage(postInfo.getOffiset(),
				postInfo.getGroudId());// 根据组列出帖子、分页
		session.put("groudId", postInfo.getGroudId());
		groud = groudService.findGroud(postInfo.getGroudId());
		
		int count = postService.getCount(postInfo.getGroudId());// 记录总数
		page = count % 10 == 0 ? count / 10 : count / 10 + 1;// 页数
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


	public Plate getPlate() {
		return plate;
	}


	public void setPlate(Plate plate) {
		this.plate = plate;
	}

	

}
